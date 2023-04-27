package pe.gob.id.sdk2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import pe.gob.id.sdk2.dto.Config;
import pe.gob.id.sdk2.dto.IdToken;
import pe.gob.id.sdk2.dto.User;
import pe.gob.id.sdk2.utils.UrlQueryString;
import pe.gob.id.sdk2.dto.TokenResponse;
import pe.gob.id.sdk2.common.Acr;
import pe.gob.id.sdk2.common.Prompt;
import pe.gob.id.sdk2.common.Scope;
import pe.gob.id.sdk2.utils.ConvertResponse;
import pe.gob.id.sdk2.utils.MySSLConnectionSocketFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Alexander Llacho
 */
public class IDGobPeClient {

    private String redirectUri = null;
    private List<Scope> lstScopes = new ArrayList<>();
    private Acr acr = Acr.ONE_FACTOR;
    private Prompt prompt = null;
    private Integer maxAge = null;
    private String state = null;
    private String loginHint = null;
    private Config config;

    public IDGobPeClient(String configFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        config = mapper.readValue(new File(configFile), Config.class);
    }

    public IDGobPeClient(InputStream configFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        config = mapper.readValue(configFile, Config.class);
    }

    public String getLoginUrl() {
        String paramScope = "openid";

        LinkedHashMap<String, Object> query = new LinkedHashMap<>();

        query.put("acr_values", this.acr.getValue());
        query.put("client_id", this.config.getClientId());
        query.put("response_type", "code");
        query.put("redirect_uri", this.redirectUri);

        if (this.prompt != null) {
            query.put("prompt", this.prompt.getValue());
        }

        if (this.state != null) {
            query.put("state", this.state);
        }

        if (this.maxAge != null) {
            query.put("max_age", this.maxAge);
        }

        if (this.loginHint != null) {
            query.put("login_hint", this.loginHint);
        }

        //lstScopes
        for (Scope scope : this.lstScopes) {
            paramScope += " " + scope.getValue();
        }

        query.put("scope", paramScope);

        return this.config.getAuthUri() + "?" + UrlQueryString.getInstance().buildQuery(query);
    }

    public TokenResponse getTokens(final String code) throws IOException {
        CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(MySSLConnectionSocketFactory.getConnectionSocketFactory()).build();
        HttpPost oRequest = new HttpPost(this.config.getTokenUri());

        oRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
        urlParameters.add(new BasicNameValuePair("code", code));
        urlParameters.add(new BasicNameValuePair("redirect_uri", this.redirectUri));
        urlParameters.add(new BasicNameValuePair("client_id", this.config.getClientId()));
        urlParameters.add(new BasicNameValuePair("client_secret", this.config.getClientSecret()));

        oRequest.setEntity(new UrlEncodedFormEntity(urlParameters, StandardCharsets.UTF_8));

        HttpResponse response = client.execute(oRequest);
        Object object = ConvertResponse.getInstance().convert(response, TokenResponse.class);

        if (object != null) {
            TokenResponse tokenResponse = (TokenResponse) object;
            IdToken idToken = new IdToken();

            try {
                String[] parts = tokenResponse.getIdToken().split("\\.");
                tokenResponse.setPayload(new String(Base64.getDecoder().decode(parts[1])));

                ObjectMapper objectMapper = new ObjectMapper();
                idToken = objectMapper.readValue(new String(Base64.getDecoder().decode(parts[1]), "UTF-8"), IdToken.class);
            } catch (Exception ex) {
                StringWriter sw = new StringWriter();
                ex.printStackTrace(new PrintWriter(sw));

                System.out.println(sw.toString());
            }

            tokenResponse.setIdTokenObject(idToken);

            return tokenResponse;
        } else {
            return null;
        }
    }

    public User getUserInfo(String accessToken) throws IOException {
        CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(MySSLConnectionSocketFactory.getConnectionSocketFactory()).build();
        HttpGet oRequest = new HttpGet(this.config.getUserInfoUri());

        oRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
        oRequest.setHeader("Authorization", "Bearer " + accessToken);

        HttpResponse response = client.execute(oRequest);
        Object object = ConvertResponse.getInstance().convert(response, User.class);

        if (object != null) {
            return (User) object;
        } else {
            return null;
        }
    }

    public String getLogoutUri(String redirectPostLogout) {
        LinkedHashMap<String, Object> query = new LinkedHashMap<>();

        query.put("post_logout_redirect_uri", redirectPostLogout);

        return this.config.getLogoutUri() + "?" + UrlQueryString.getInstance().buildQuery(query);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAcr(Acr acr) {
        this.acr = acr;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public void addScope(Scope scope) {
        this.lstScopes.add(scope);
    }

    public void cleanScopes() {
        this.lstScopes.clear();
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public Config getConfig() {
        return config;
    }

    public void setLoginHint(String loginHint) {
        this.loginHint = loginHint;
    }
}

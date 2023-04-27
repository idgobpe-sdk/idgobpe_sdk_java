package pe.gob.id.sdk2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexander Llacho
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponse {

    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("id_token")
    private String idToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("payload")
    private String payload;
    private IdToken idTokenObject;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public IdToken getIdTokenObject() {
        return idTokenObject;
    }

    public void setIdTokenObject(IdToken idTokenObject) {
        this.idTokenObject = idTokenObject;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "tokenType='" + tokenType + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", idToken='" + idToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", payload='" + payload + '\'' +
                ", idTokenObject=" + idTokenObject +
                '}';
    }
}

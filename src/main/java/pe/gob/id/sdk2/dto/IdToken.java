package pe.gob.id.sdk2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Alexander Llacho
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdToken {

    @JsonProperty("acr")
    private String acr;
    @JsonProperty("aud")
    private List<String> aud;
    @JsonProperty("sub")
    private String sub;
    @JsonProperty("doc")
    private String doc;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("exp")
    private Integer exp;
    @JsonProperty("iat")
    private Integer iat;
    @JsonProperty("iss")
    private String iss;
    @JsonProperty("nonce")
    private String nonce;
    @JsonProperty("at_hash")
    private String athash;
    @JsonProperty("c_hash")
    private String chash;

    public IdToken() {
    }

    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr;
    }

    public List<String> getAud() {
        return aud;
    }

    public void setAud(List<String> aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getIat() {
        return iat;
    }

    public void setIat(Integer iat) {
        this.iat = iat;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getAthash() {
        return athash;
    }

    public void setAthash(String athash) {
        this.athash = athash;
    }

    public String getChash() {
        return chash;
    }

    public void setChash(String chash) {
        this.chash = chash;
    }

    @Override
    public String toString() {
        return "IdToken{" +
                "acr='" + acr + '\'' +
                ", aud=" + aud +
                ", sub='" + sub + '\'' +
                ", doc='" + doc + '\'' +
                ", firstName='" + firstName + '\'' +
                ", exp=" + exp +
                ", iat=" + iat +
                ", iss='" + iss + '\'' +
                ", nonce='" + nonce + '\'' +
                ", athash='" + athash + '\'' +
                ", chash='" + chash + '\'' +
                '}';
    }
}
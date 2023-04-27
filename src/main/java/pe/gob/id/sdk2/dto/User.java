package pe.gob.id.sdk2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexander Llacho
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("doc_type")
    private String docType;
    @JsonProperty("doc")
    private String doc;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("ruc")
    private String ruc;
    @JsonProperty("sub")
    private String sub;

    public User() {
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "User{" +
                "docType='" + docType + '\'' +
                ", doc='" + doc + '\'' +
                ", firstName='" + firstName + '\'' +
                ", ruc='" + ruc + '\'' +
                ", sub='" + sub + '\'' +
                '}';
    }
}
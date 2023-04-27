package pe.gob.id.sdk2.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Llacho
 */
public enum Acr {

    CERTIFICATE_DNIE("certificate_dnie"),
    CERTIFICATE_TOKEN("certificate_token"),
    ONE_FACTOR("one_factor"),
    TWO_FACTOR("two_factor"),
    CERTIFICATE_DNIE_LEGACY("certificate_dnie_legacy"),
    CERTIFICATE_TOKEN_LEGACY("certificate_token_legacy");

    private final String value;
    private static final Map<String, Acr> lookup = new HashMap<>();

    static {
        for (Acr d : Acr.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    Acr(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Acr get(String value) {
        return lookup.get(value);
    }
}

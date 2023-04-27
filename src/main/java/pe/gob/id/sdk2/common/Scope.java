package pe.gob.id.sdk2.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Llacho
 */
public enum Scope {
    PROFILE("profile"),
    EMAIL("email"),
    PHONE("phone"),
    OFFLINE_ACCESS("offline_access");

    private final String value;
    private static final Map<String, Scope> lookup = new HashMap<>();

    static {
        for (Scope d : Scope.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    Scope(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Scope get(String value) {
        return lookup.get(value);
    }
}

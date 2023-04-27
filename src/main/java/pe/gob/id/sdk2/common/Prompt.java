package pe.gob.id.sdk2.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Llacho
 */
public enum Prompt {

    NONE("none"),
    LOGIN("login"),
    CONSENT("consent");

    private final String value;
    private static final Map<String, Prompt> lookup = new HashMap<>();

    static {
        for (Prompt d : Prompt.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    Prompt(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Prompt get(String value) {
        return lookup.get(value);
    }
}

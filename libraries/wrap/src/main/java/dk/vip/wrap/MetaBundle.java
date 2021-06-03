package dk.vip.wrap;

import java.util.HashMap;
import java.util.Map;

/**
 * MetaBundles are made up of key value pairs in a map called properties which
 * are transformed to and from JSON when used.
 */
public class MetaBundle {
    private final String name;
    private final Map<String, Object> properties;

    public MetaBundle(String name) {
        properties = new HashMap<>();
        this.name = name;
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }
    //getValue
    public Object get(String key){
        return properties.get(key);
    }

    public String getName() {
        return name;
    }
}

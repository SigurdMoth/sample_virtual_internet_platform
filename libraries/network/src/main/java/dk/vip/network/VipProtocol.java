package dk.vip.network;

import java.util.HashMap;
import java.util.Map;

public class VipProtocol {

    private String name;
    private Map<String, Object> properties;

    public VipProtocol(String name) {
        this.name = name;
        properties = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", properties='" + getProperties() + "'" + "}";
    }

}

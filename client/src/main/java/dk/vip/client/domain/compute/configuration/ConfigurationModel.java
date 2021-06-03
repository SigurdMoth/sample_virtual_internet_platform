package dk.vip.client.domain.compute.configuration;

import dk.vip.wrap.Bundlable;

public abstract class ConfigurationModel implements Bundlable {

    private final String path;

    public ConfigurationModel(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

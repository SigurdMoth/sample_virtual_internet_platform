package dk.vip.client.domain.compute.configuration.models;

import dk.vip.client.domain.compute.configuration.ConfigurationModel;
import dk.vip.wrap.MetaBundle;

public class UserConfiguration extends ConfigurationModel  {

    private String name;

    public UserConfiguration(String path) {
        super(path);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }

    @Override
    public MetaBundle bundle() {
        MetaBundle metaBundle = new MetaBundle("userbundle");
        metaBundle.put("name", getName());
        return metaBundle;
    }
}

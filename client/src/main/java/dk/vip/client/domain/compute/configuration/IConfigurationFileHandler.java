package dk.vip.client.domain.compute.configuration;

public interface IConfigurationFileHandler {

    boolean save(ConfigurationModel config);

    <T extends ConfigurationModel> T load (Class<T> config, String path);
}

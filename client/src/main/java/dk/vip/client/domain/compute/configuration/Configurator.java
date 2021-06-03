package dk.vip.client.domain.compute.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dk.vip.client.domain.compute.configuration.models.NetworkConfiguration;
import dk.vip.client.domain.compute.configuration.models.UserConfiguration;

@Component
public class Configurator {

    private final IConfigurationFileHandler fileHandler;
    // Configurationmodel = instance of a configuration file
    private final Map<Class, ConfigurationModel> configurationModels;

    @Autowired
    private Configurator(IConfigurationFileHandler fileHandler) {
        this.fileHandler = fileHandler;
        configurationModels = new HashMap<>();
        configurationModels.put(NetworkConfiguration.class, new NetworkConfiguration("cfgNetwork.json"));
        configurationModels.put(UserConfiguration.class, new UserConfiguration("cfgUser.json"));
        loadAllConfigs();
    }

    public void saveConfig(Class config) {
        fileHandler.save(configurationModels.get(config));
    }

    public <T extends ConfigurationModel> T loadConfig(Class<T> config) {
        return fileHandler.load(config, configurationModels.get(config).getPath());
    }

    public void loadAllConfigs() {
        for (ConfigurationModel oldConfigurationModel : configurationModels.values()) {
            ConfigurationModel newConfigurationModel = loadConfig(oldConfigurationModel.getClass());
            if (newConfigurationModel != null) {
                configurationModels.put(oldConfigurationModel.getClass(), newConfigurationModel);
            }
        }
    }

    public <T extends ConfigurationModel> T get(Class<T> classModel) {
        return (T) configurationModels.get(classModel);
    }

}

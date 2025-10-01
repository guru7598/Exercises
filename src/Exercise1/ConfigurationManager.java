package Exercise1;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private ConfigurationManager() {}
    public static ConfigurationManager getInstance() {
        if (instance == null) instance = new ConfigurationManager();
        return instance;
    }
    public void showConfig() {
        System.out.println("Configuration settings...");
    }
}

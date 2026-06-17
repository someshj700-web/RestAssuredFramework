package Util;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {

        try {
            String env = System.getProperty("env");

            // Default environment
            if (env == null) {
                env = "qa";
            }

            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config-" + env + ".properties");

            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBaseURL() {
        return prop.getProperty("baseURL");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }
}

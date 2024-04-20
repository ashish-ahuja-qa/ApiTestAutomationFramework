package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    private static final String CONFIG_FILE_PATH = "src/test/resources/testconfig.properties";
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(CONFIG_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base_url");
    }
}

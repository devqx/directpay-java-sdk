package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {
    private final static Properties properties = new Properties();
    static {
        InputStream inputStream = ApiConfig.class.getClassLoader().getResourceAsStream("api_endpoints.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

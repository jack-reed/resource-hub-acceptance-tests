package utils.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    public static void main(String[] args) {
        reedPropertiesFile();
    }

    public static void reedPropertiesFile() {
        Properties properties = new Properties();
        try {
            String location = System.getProperty("user.dir");
            InputStream input = new FileInputStream(location+"/src/test/java/utils/config/config.properties");

            properties.load(input);
            System.out.println(properties.getProperty("TIMEOUT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
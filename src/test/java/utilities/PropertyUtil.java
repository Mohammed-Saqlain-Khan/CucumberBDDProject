package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

final public class PropertyUtil {

    private PropertyUtil()
    {

    }

    public static final String config_properties_path="./src/test/resources/config.properties";

    public static String getBrowser() throws IOException {
    FileInputStream fi = new FileInputStream(config_properties_path);
        Properties pr = new Properties();
        pr.load(fi);

        return pr.getProperty("browser");

    }




}

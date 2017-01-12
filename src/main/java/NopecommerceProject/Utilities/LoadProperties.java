package NopecommerceProject.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by kaival on 30/11/2016.
 */
public class LoadProperties {
    static Properties prop;
    static String propertiesFileLocation = "src\\test\\resources\\Properties\\";
    static String propFileName="Nopecommerce.properties";
    static FileInputStream input;

    public static String getProperty(String key)
    {
        prop = new Properties();
        try {
            //providing property file path as input
            input = new FileInputStream(propertiesFileLocation + propFileName);
            prop.load(input);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}

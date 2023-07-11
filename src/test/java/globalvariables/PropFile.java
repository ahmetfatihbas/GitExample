package globalvariables;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropFile {
    public static void main(String[] args) throws IOException {
   /*     Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("configuration.properties");
        prop.load(fis);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        prop.setProperty("OS", "Linux");

        FileOutputStream fos= new FileOutputStream("configuration.properties");
        prop.store(fos,null);

        System.out.println(prop.getProperty("OS")); */
    String  value = Config.getProperty("OS");
        String  value2 = Config.getProperty("browser");

        System.out.println(value + "  " + value2);
    }


}

package BaseDir;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SettingsReader {
    static Properties props;
    public static String browser;
    public static String url;
    public static int waitTime;
    public static String passwordFromProp;
    public static String user1;
    public static String user2;
    public static String user3;
    public static String user4;

    static {
        props = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/configuration/config.properties")) {
            props.load(input);
            browser = props.getProperty("browser");
            url = props.getProperty("url");
            waitTime = Integer.parseInt(props.getProperty("waitTime"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (InputStream input2 = new FileInputStream("src/main/resources/test_data.properties")) {
            props.load(input2);
            user1 = props.getProperty("first");
            user2 = props.getProperty("second");
            user3 = props.getProperty("third");
            user4 = props.getProperty("four");
            passwordFromProp = props.getProperty("password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

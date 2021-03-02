package read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadFile {

    public static ResourceBundle readProp(String systemSourcesDir){
        ResourceBundle bundle = null;
        try {
            String propertyDir = "/src/test/resources/properties/"+systemSourcesDir+".properties";

            InputStream propertiesStream = new FileInputStream(System.getProperty("user.dir") + propertyDir);

            bundle = new PropertyResourceBundle(new InputStreamReader(propertiesStream, StandardCharsets.UTF_8));

            propertiesStream.close();
            System.out.println(bundle);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("hata");
        }
        return bundle;
    }

    public void testFonk(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println("kelime");

    }
}
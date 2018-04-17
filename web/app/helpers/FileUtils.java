package helpers;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileUtils {

    public static JsonObject getJsonFromFile(File f){
        if (f != null){
            JsonParser parser = new JsonParser();
            try {
                return parser.parse(new FileReader(f)).getAsJsonObject();
            } catch (FileNotFoundException e) {}
        }

        return new JsonObject();
    }
}

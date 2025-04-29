package com.larand.JavaWeb;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

    public static JSONObject readJsonFile(String filePath) throws Exception {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        Object obj = parser.parse(reader);
        reader.close();
        return (JSONObject) obj;
    }
}

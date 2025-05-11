package starter.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtils {
    public static JsonNode readJson(String path) throws IOException {
        String content = Files.readString(Paths.get(path));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(content);
    }

    public static String getValue(String path, String key) throws IOException {
        return readJson(path).get(key).asText();
    }
}
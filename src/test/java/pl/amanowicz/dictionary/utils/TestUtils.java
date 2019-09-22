package pl.amanowicz.dictionary.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

public class TestUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T readValue(MvcResult result, Class<T> returnType) throws IOException {
        String content = result.getResponse().getContentAsString();

        return MAPPER.readValue(content, returnType);
    }
}

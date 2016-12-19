package test;

import org.junit.Test;
import task.utils.TextUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class TextUtilsTest {
    @Test
    public void determineFrequencyWordsTest() throws FileNotFoundException, IOException {
        Map<String, Integer> expectation = new HashMap<>();
        Map<String, Integer> result = null;
        String sourceFileName = "src/resources/source-test.txt";

        expectation.put("one", 3);
        expectation.put("two", 2);

        result = TextUtils.determineFrequencyWords(new FileReader(sourceFileName));

        assertEquals(result, expectation);
    }
}
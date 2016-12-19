package task.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class TextUtils {

    private TextUtils() {
    }

    public static Map<String, Integer> determineFrequencyWords(String text) {

        Map<String, Integer> frequencyWords = new HashMap<>();
        text = text.replaceAll("\\p{Punct}|\\—", " ").replaceAll("[\\s]{2,}", " ");
        for (String word: text.split(" ")) {
            word = word.toLowerCase();
            Integer frequency = frequencyWords.get(word);
            if (frequency == null) {
                frequencyWords.put(word, 1);
            }
            else {
                frequencyWords.put(word, ++frequency);
            }
        }
        return frequencyWords;
    }

    public static Map<String, Integer> determineFrequencyWords(Reader reader) throws IOException {

        Map<String, Integer> frequencyWords = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                combine(determineFrequencyWords(line), frequencyWords);
            }
        }
        return frequencyWords;
    }

    private static void combine(Map<String, Integer> added, Map<String, Integer> result) {
        for (String key: added.keySet()) {

            Integer value = result.get(key);
            if (value == null) {
                value = added.get(key);
            }
            else {
                value += added.get(key);
            }
            result.put(key, value);
        }
    }
}

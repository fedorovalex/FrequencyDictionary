package task.utils;


import java.util.Map;

public class MapUtils {
    public static <K, V> String makePrinting(Map<K, V> source) {
        String result = "";
        for (K kay: source.keySet()) {
            result += kay.toString() + ": " + source.get(kay).toString() + ";\n";
        }
        return result;
    }
}

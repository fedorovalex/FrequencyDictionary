package task;

import task.exception.NoArgumentsWithNameFile;
import task.utils.MapUtils;
import task.utils.TextUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import static task.utils.Helper.getHelp;

public class FrequencyDictionary {

    public static void main(String[] args) throws IOException, NoArgumentsWithNameFile {
        if (args == null || args.length < 1) {
            System.out.println(getHelp());
            throw new NoArgumentsWithNameFile("Не указано имя файла.");
        }

        String sourceFileName = args[0];
        Map<String, Integer> frequencyWords = null;

        Reader reader = null;
        try {
            reader = new FileReader(sourceFileName);
            frequencyWords = TextUtils.determineFrequencyWords(reader);
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            System.out.println(getHelp());
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }

        if (frequencyWords != null) {
            System.out.println(MapUtils.makePrinting(frequencyWords));
        }
    }
}

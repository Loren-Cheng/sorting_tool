package sorting;

import java.io.InputStream;
import java.util.*;

class ConfigReader {
    /*
     * */

    static Map<String, String> readConfig(String[] args) {
        int count = args.length;
        Map<String, String> configMap = new HashMap<>();
        Set<String> keyWords = new HashSet<>();
        Set<String> dataTypeWords = Set.of("word", "long", "line");
        Set<String> argsWords = Set.of("java", "SortingTool", "-sortingType", "-dataType", "-inputFile", "-outputFile");
        Set<String> sortingTypeWord = Set.of("byCount", "natural");
        keyWords.addAll(dataTypeWords);
        keyWords.addAll(argsWords);
        keyWords.addAll(sortingTypeWord);
        for (int i = 0; i < count; i++) {
            if (!keyWords.contains(args[i])) {
                System.out.println(args[i] + " is not a valid parameter. It will be skipped.");
            } else if ("-sortingType".equals(args[i])) {
                if (i + 1 < count && sortingTypeWord.contains(args[i + 1])) {
                    configMap.put("sortingType", args[i + 1]);
                } else {
                    System.out.println("No sorting type defined!");
                    System.exit(0);
                }
            } else if ("-dataType".equals(args[i])) {
                if (i + 1 < count && dataTypeWords.contains(args[i + 1])) {
                    configMap.put("dataType", args[i + 1]);
                } else {
                    System.out.println("No data type defined!");
                    System.exit(0);
                }
            } else if ("-inputFile".equals(args[i])) {
                if (i + 1 < count) {
                    configMap.put("inputDest", args[i + 1]);
                    i += 1;
                }

            } else if ("-outputFile".equals(args[i])) {
                if (i + 1 < count) {
                    configMap.put("outputDest", args[i + 1]);
                    i += 1;
                }

            }
        }
        return configMap;
    }


}

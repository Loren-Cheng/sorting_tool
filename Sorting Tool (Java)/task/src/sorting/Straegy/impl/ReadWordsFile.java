package sorting.Straegy.impl;

import sorting.entity.NumData;
import sorting.entity.NumDataWords;

import java.util.Scanner;

public class ReadWordsFile extends ReadTxtFile<NumDataWords, String> {
    public ReadWordsFile(String filePath) {
        super();
    }

    @Override
    protected NumDataWords createNumData() {
        return new NumDataWords();
    }

    @Override
    protected String readValue(Scanner scanner) {
        return scanner.next();
    }

}

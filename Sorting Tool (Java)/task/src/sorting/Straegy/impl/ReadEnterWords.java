package sorting.Straegy.impl;

import sorting.entity.NumData;
import sorting.entity.NumDataWords;

import java.util.Scanner;

public class ReadEnterWords extends ReadSystemIn<NumDataWords, String> {

    @Override
    protected NumDataWords createNumData() {
        return new NumDataWords();
    }

    @Override
    protected String readValue(Scanner scanner) {
        return scanner.next();
    }

    @Override
    protected boolean hasNext(Scanner scanner) {
        return scanner.hasNext();
    }

    @Override
    public NumData read(String inputType) {
        return null;
    }
}

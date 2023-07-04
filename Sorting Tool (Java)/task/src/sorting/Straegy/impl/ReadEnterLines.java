package sorting.Straegy.impl;

import sorting.entity.NumData;
import sorting.entity.NumDataLines;

import java.util.Scanner;

public class ReadEnterLines extends ReadSystemIn<NumDataLines, String> {

    @Override
    protected NumDataLines createNumData() {
        return new NumDataLines();
    }

    @Override
    protected String readValue(Scanner scanner) {
        return scanner.nextLine();
    }

    @Override
    protected boolean hasNext(Scanner scanner) {
        return scanner.hasNextLine();
    }

    @Override
    public NumData read(String inputType) {
        return null;
    }
}


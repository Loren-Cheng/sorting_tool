package sorting.Straegy.impl;

import sorting.entity.NumData;
import sorting.entity.NumDataLongs;

import java.util.Scanner;

public class ReadEnterLongs extends ReadSystemIn<NumDataLongs, Long> {
    @Override
    protected NumDataLongs createNumData() {
        return new NumDataLongs();
    }

    @Override
    protected Long readValue(Scanner scanner) {
        return scanner.nextLong();
    }

    @Override
    protected boolean hasNext(Scanner scanner) {
        return scanner.hasNextLong();
    }

    @Override
    public NumData read(String inputType) {
        return null;
    }
}

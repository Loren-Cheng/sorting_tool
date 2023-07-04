package sorting.Straegy.impl;

import sorting.entity.NumData;
import sorting.entity.NumDataLines;
import sorting.entity.NumDataLongs;

import java.util.Scanner;

public class ReadLongsFile extends ReadTxtFile<NumDataLongs, Long> {

    public ReadLongsFile(String filePath) {
        super();
    }

    @Override
    protected NumDataLongs createNumData() {
        return new NumDataLongs();
    }

    @Override
    protected Long readValue(Scanner scanner) {
        return scanner.nextLong();
    }


}

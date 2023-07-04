package sorting.Straegy.impl;

import sorting.entity.NumData;
import sorting.entity.NumDataLines;
import sorting.entity.NumDataLongs;

import java.util.Scanner;

public class ReadLinesFile extends ReadTxtFile<NumDataLines, String> {
    public ReadLinesFile(String filePath) {
        super();
    }

    @Override
    protected NumDataLines createNumData() {
        return new NumDataLines();
    }

    @Override
    protected String readValue(Scanner scanner) {
        return scanner.nextLine();
    }




}

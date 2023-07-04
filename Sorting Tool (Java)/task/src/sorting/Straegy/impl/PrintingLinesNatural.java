package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.Straegy.Printer;

import java.io.IOException;

public class PrintingLinesNatural implements Printer<NumDataLines> {

    @Override
    public void print(NumDataLines data) {
        System.out.println("Total lines: " + data.getTotal());
        System.out.println("Sorted data:");
        for (String line : data.getData()
        ) {
            System.out.println(line);
        }
    }

    @Override
    public void print(NumDataLines data, String dest) throws IOException {
        throw new RuntimeException("No such methods.");
    }
}

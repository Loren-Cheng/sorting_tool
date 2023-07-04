package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.entity.NumDataLongs;
import sorting.Straegy.Printer;

import java.io.IOException;

public class PrintingLongsNatural implements Printer<NumDataLongs> {
    public void print(NumDataLongs data) {
        System.out.println("Total numbers: " + data.getTotal() + ".");
        System.out.print("Sorted data: ");
        for (long num : data.getData()
        ) {
            System.out.print(num + " ");
        }
    }

    @Override
    public void print(NumDataLongs data, String dest) throws IOException {
        throw new RuntimeException("No such methods.");
    }
}

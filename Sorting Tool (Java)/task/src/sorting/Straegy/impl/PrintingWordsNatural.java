package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.entity.NumDataWords;
import sorting.Straegy.Printer;

import java.io.IOException;

public class PrintingWordsNatural implements Printer<NumDataWords> {

    @Override
    public void print(NumDataWords data) {
        System.out.println("Total words: " + data.getTotal() + ".");
        System.out.print("Sorted data: ");
        for (String num : data.getData()
        ) {
            System.out.print(num + " ");
        }
    }

    @Override
    public void print(NumDataWords data, String dest) throws IOException {
        throw new RuntimeException("No such methods.");
    }
}

package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.entity.NumDataLongs;
import sorting.Straegy.Printer;

import java.io.IOException;

public class PrintingLongsByCount implements Printer<NumDataLongs> {
    public void print(NumDataLongs data) {
        System.out.println("Total numbers: " + data.getTotal() + ".");
        for (long num : data.getData()
        ) {
            int times = data.getFrequencyMap().get(num);
            System.out.println(num + ": " + times + " time(s), " + Math.round((float) times / data.getTotal() * 100) + "%");
        }
    }

    @Override
    public void print(NumDataLongs data, String dest) throws IOException {
        throw new RuntimeException("No such methods.");
    }
}

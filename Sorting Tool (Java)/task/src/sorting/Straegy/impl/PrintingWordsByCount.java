package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.entity.NumDataWords;
import sorting.Straegy.Printer;

import java.io.IOException;
import java.util.Iterator;

public class PrintingWordsByCount implements Printer<NumDataWords> {

    @Override
    public void print(NumDataWords data) {
        System.out.println("Total words: " + data.getTotal() + ".");
        Iterator<String> iterator = data.getData().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            int times = data.getFrequencyMap().get(num);
            System.out.println(num + ": " + times + " time(s), " + Math.round((float) times / data.getTotal() * 100) + "%");
        }
    }

    @Override
    public void print(NumDataWords data, String dest) throws IOException {
        throw new RuntimeException("No such methods.");
    }
}

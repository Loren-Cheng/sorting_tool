package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.Straegy.Printer;

import java.util.Iterator;

public class PrintingLinesByCount implements Printer<NumDataLines> {

    @Override
    public void print(NumDataLines data) {
        System.out.println("Total lines: " + data.getTotal() + ".");
        Iterator<String> iterator = data.getData().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            int times = data.getFrequencyMap().get(num);
            System.out.println(num + ": " + times + " time(s), " + Math.round((float) times / data.getTotal() * 100) + "%");
        }
    }

    @Override
    public void print(NumDataLines data, String dest) {
        throw new RuntimeException("No such methods.");
    }
}

package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.Straegy.SortingStrategy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingLinesNatural implements SortingStrategy<NumDataLines> {

    @Override
    public NumDataLines sort(NumDataLines data) {
        Comparator<String> linesComparator = (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        };
        NumDataLines sortedData = new NumDataLines();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(linesComparator);
        priorityQueue.addAll(data.getData());

        while (!priorityQueue.isEmpty()) {
            sortedData.add(priorityQueue.poll());
        }
        sortedData.setTotal(data.getTotal());

        return sortedData;
    }
}

package sorting.Straegy.impl;

import sorting.entity.NumDataWords;
import sorting.Straegy.SortingStrategy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingWordsNatural implements SortingStrategy<NumDataWords> {

    @Override
    public NumDataWords sort(NumDataWords data) {
        Comparator<String> wordsComparator = (String::compareTo);
        NumDataWords sortedData = new NumDataWords();
        sortedData.setTotal(data.getTotal());
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(wordsComparator);
        while (!priorityQueue.isEmpty()) {
            sortedData.getData().add(priorityQueue.poll());
        }

        return sortedData;
    }
}

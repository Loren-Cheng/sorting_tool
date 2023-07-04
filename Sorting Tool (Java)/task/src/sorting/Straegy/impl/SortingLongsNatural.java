package sorting.Straegy.impl;

import sorting.entity.NumDataLongs;
import sorting.Straegy.SortingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortingLongsNatural implements SortingStrategy<NumDataLongs> {
    public NumDataLongs sort(NumDataLongs data) {
        Comparator<Long> numDataLongsComparator = (num1, num2) -> num1.compareTo(num2);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(numDataLongsComparator);
        priorityQueue.addAll(data.getData());
        NumDataLongs sortedData = new NumDataLongs();
        List<Long> sortedLongs = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            sortedLongs.add(priorityQueue.poll());
        }
        sortedData.setData(List.copyOf(sortedLongs));
        sortedData.setTotal(data.getTotal());
        sortedData.setFrequencyMap(data.getFrequencyMap());
        return sortedData;
    }
}

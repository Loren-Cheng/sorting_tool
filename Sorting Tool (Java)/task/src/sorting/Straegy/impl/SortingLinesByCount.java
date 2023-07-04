package sorting.Straegy.impl;

import sorting.entity.NumDataLines;
import sorting.Straegy.SortingStrategy;

import java.util.*;

public class SortingLinesByCount implements SortingStrategy<NumDataLines> {

    @Override
    public NumDataLines sort(NumDataLines data) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        Iterator<String> iterator = data.getData().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        Comparator<String> countComparator = (a, b) -> {
            return frequencyMap.get(a) - frequencyMap.get(b);
        };
        PriorityQueue<String> pq = new PriorityQueue<>(countComparator.thenComparing((a, b) -> a.compareTo(b)));
        pq.addAll(frequencyMap.keySet());
        NumDataLines sortedData = new NumDataLines();
        while (!pq.isEmpty()) {
            sortedData.getData().add(pq.poll());
        }
        sortedData.setFrequencyMap(frequencyMap);
        sortedData.setTotal(data.getTotal());
        return sortedData;
    }
}

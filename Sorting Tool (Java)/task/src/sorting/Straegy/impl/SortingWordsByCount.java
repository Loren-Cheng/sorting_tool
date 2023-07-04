package sorting.Straegy.impl;

import sorting.entity.NumDataWords;
import sorting.Straegy.SortingStrategy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortingWordsByCount implements SortingStrategy<NumDataWords> {

    @Override
    public NumDataWords sort(NumDataWords data) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
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
        NumDataWords sortedData = new NumDataWords();
        while (!pq.isEmpty()) {
            sortedData.getData().add(pq.poll());
        }
        sortedData.setFrequencyMap(frequencyMap);
        sortedData.setTotal(data.getTotal());
        return sortedData;
    }
}

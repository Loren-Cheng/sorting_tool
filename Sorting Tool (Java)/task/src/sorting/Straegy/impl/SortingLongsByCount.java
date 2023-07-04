package sorting.Straegy.impl;

import sorting.entity.NumDataLongs;
import sorting.Straegy.SortingStrategy;

import java.util.*;

public class SortingLongsByCount implements SortingStrategy<NumDataLongs> {
    public NumDataLongs sort(NumDataLongs data) {
        NumDataLongs sortedData = new NumDataLongs();

        Map<Long, Integer> frequencyMap = sortedData.getFrequencyMap();
        for (long num : data.getData()
        ) {
            sortedData.add(num);
        }

        // 建立一個Comparator排序，先依出現頻率，次依Long大小，遞增排序

        Comparator<Long> countComparator = (num1, num2) -> {
            return frequencyMap.get(num1).compareTo(frequencyMap.get(num2));
        };
        // 使用PriorityQueue排序
        PriorityQueue<Long> pq = new PriorityQueue<>(countComparator.thenComparing((a, b) -> a.compareTo(b)));
        pq.addAll(sortedData.getFrequencyMap().keySet());

        sortedData.setTotal(data.getTotal());
        sortedData.setData(new ArrayList<>());
        while (!pq.isEmpty()) {
            sortedData.getData().add(pq.poll());
        }
        return sortedData;
    }
}

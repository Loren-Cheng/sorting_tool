package sorting.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class NumData<T> {
    int total;
    List<T> data = new ArrayList<>();
    Map<T, Integer> frequencyMap = new HashMap<>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map<T, Integer> getFrequencyMap() {
        return frequencyMap;
    }

    public void setFrequencyMap(Map<T, Integer> frequencyMap) {
        this.frequencyMap = frequencyMap;
    }

    public void add(T value) {
        this.data.add(value);
        this.frequencyMap.put(value, this.frequencyMap.getOrDefault(value, 0) + 1);
        ++this.total;
    }
}

package sorting.Straegy;

import sorting.entity.NumData;

public interface SortingStrategy<T extends NumData> {
    T sort(T data);
}

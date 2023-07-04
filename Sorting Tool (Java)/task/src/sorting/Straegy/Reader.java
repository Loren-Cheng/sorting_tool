package sorting.Straegy;

import sorting.entity.NumData;

public interface Reader<T extends NumData> {
    T read();

    T read(String inputType);
}

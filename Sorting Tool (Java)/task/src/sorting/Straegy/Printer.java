package sorting.Straegy;

import sorting.entity.NumData;
import sorting.entity.NumDataLines;

import java.io.IOException;

public interface Printer<T extends NumData> {
    void print(T data);

    void print(T data, String dest) throws IOException;
}

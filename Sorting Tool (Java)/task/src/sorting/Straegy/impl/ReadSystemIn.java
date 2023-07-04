package sorting.Straegy.impl;

import sorting.Straegy.Reader;
import sorting.entity.NumData;
import sorting.entity.NumDataLines;
import sorting.entity.NumDataLongs;
import sorting.entity.NumDataWords;

import java.util.Scanner;

public abstract class ReadSystemIn<T extends NumData<U>, U> implements Reader {
    protected abstract T createNumData();

    protected abstract U readValue(Scanner scanner);

    protected abstract boolean hasNext(Scanner scanner);

    @Override
    public T read() {
        T aftInput = createNumData();
        Scanner scanner = new Scanner(System.in);
        boolean hasNext = hasNext(scanner);
        while (hasNext) {
            U value = readValue(scanner);//scanner.next(), scanner.nextLong(), scanner.nextLine()

            if (aftInput instanceof NumDataLongs) {
                if (hasNext) {
                    aftInput.add(value);
                } else if (scanner.hasNext()) {
                    System.out.println(scanner.next() + " is not a long. It will be skipped.");
                }
            } else if (aftInput instanceof NumDataWords
                    || aftInput instanceof NumDataLines) {
                aftInput.add(value);
            }
            hasNext = hasNext(scanner);
        }
        return aftInput;
    }
}


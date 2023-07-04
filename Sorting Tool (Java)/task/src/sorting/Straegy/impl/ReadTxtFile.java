package sorting.Straegy.impl;

import sorting.Straegy.Reader;
import sorting.entity.NumData;
import sorting.entity.NumDataLines;
import sorting.entity.NumDataLongs;
import sorting.entity.NumDataWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class ReadTxtFile<T extends NumData<U>, U> implements Reader {

    protected abstract T createNumData();

    protected abstract U readValue(Scanner scanner);

    @Override
    public T read(String path) {
        String currentDir = System.getProperty("user.dir");
        path = currentDir + "/" + path;//jetBrain測試資料位置
//        path = currentDir + "/Sorting Tool (Java)/task/src/sorting/" + path;

        File file = new File(path);

        T aftInput = createNumData();
        Scanner scanner;

        try {
            scanner = new Scanner(file);
            while (hasNext(scanner, aftInput)) {
                U value = readValue(scanner);
                if (aftInput instanceof NumDataLongs) {
                    if (scanner.hasNextLong()) {
                        aftInput.add(value);
                    } else {
                        System.out.println(scanner.next() + " is not a long. It will be skipped.");
                    }
                } else if (aftInput instanceof NumDataWords
                        || aftInput instanceof NumDataLines) {
                    aftInput.add(value);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return aftInput;
    }
    @Override
    public T read() {
        throw new RuntimeException("Method not available");
    }

    boolean hasNext(Scanner scanner, T input) {
        if (input instanceof NumDataLines) {
            return scanner.hasNextLine();
        } else if (input instanceof NumDataLongs) {
            return scanner.hasNextLong();
        } else if (input instanceof NumDataWords) {
            return scanner.hasNext();
        } else return false;
    }


}

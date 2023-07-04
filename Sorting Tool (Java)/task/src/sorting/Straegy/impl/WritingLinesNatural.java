package sorting.Straegy.impl;

import sorting.Straegy.Printer;
import sorting.entity.NumDataLines;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WritingLinesNatural implements Printer<NumDataLines> {


    @Override
    public void print(NumDataLines data) {
        throw new RuntimeException("No such methods.");
    }

    @Override
    public void print(NumDataLines data, String dest) throws IOException {
        String currentDir = System.getProperty("user.dir");
        dest = currentDir + "/" + dest;//jetBrain測試資料位置
//        dest = currentDir + "/Sorting Tool (Java)/task/src/sorting/" + dest;
        File file = new File(dest);
        FileWriter writer = new FileWriter(file); // overwrites the file

        writer.write("Total lines: " + data.getTotal() + ".\n");
        Iterator<String> iterator = data.getData().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            int times = data.getFrequencyMap().get(num);
            writer.write(num + ": " + times + " time(s), " + Math.round((float) times / data.getTotal() * 100) + "%\n");
        }

        writer.close();
    }
}

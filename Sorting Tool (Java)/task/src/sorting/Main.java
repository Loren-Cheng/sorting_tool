package sorting;

import sorting.entity.NumData;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, String> configMap = ConfigReader.readConfig(args);

        // 建立控制器
        SortingTool controller = new SortingTool(configMap);

        //讀取commandLine
        NumData numData = controller.readInput();

        //排序
        numData = controller.sort(numData);

        //顯示
        controller.print(numData);
    }
}



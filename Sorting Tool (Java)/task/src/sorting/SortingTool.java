package sorting;

import sorting.Straegy.Printer;
import sorting.Straegy.Reader;
import sorting.Straegy.SortingStrategy;
import sorting.Straegy.impl.*;
import sorting.entity.NumData;
import sorting.entity.NumDataLines;
import sorting.entity.NumDataLongs;
import sorting.entity.NumDataWords;

import java.io.IOException;
import java.util.Map;

// 在controller中引用讀取，排序及顯示策略
public class SortingTool {
    private Configs configs;
    private NumData model;
    private Printer printingStrategy;
    private Reader readInputStrategy;
    private SortingStrategy sortingStrategy;

    private static class Configs {
        private final String dataType;
        private final String inputDest;
        private final String outputDest;
        private final String sortingType;


        public Configs(Map<String, String> configMap) {
            this.dataType = configMap.getOrDefault("dataType", "line");
            this.inputDest = configMap.getOrDefault("inputDest", "System.in");
            this.outputDest = configMap.getOrDefault("outputDest", "CommandLine");
            this.sortingType = configMap.getOrDefault("sortingType", "natural");
        }

        public String getDataType() {
            return dataType;
        }

        public String getInputDest() {
            return inputDest;
        }

        public String getOutputDest() {
            return outputDest;
        }

        public String getSortingType() {
            return sortingType;
        }

        @Override
        public String toString() {
            return "Configs{" +
                    "dataType='" + dataType + '\'' +
                    ", inputDest='" + inputDest + '\'' +
                    ", outputDest='" + outputDest + '\'' +
                    ", sortingType='" + sortingType + '\'' +
                    '}';
        }
    }

    public SortingTool(Map<String, String> configMap) {
        this.configs = new Configs(configMap);

        String dataType = this.configs.getDataType();
        String inputDest = this.configs.getInputDest();
        String outputDest = this.configs.getOutputDest();
        String sortingType = this.configs.getSortingType();

        this.model = getModelByDataType(dataType);
        this.readInputStrategy = InputReaderFactory.createInputReader(dataType, inputDest);
        this.sortingStrategy = SortingStrategyFactory.createSortingStrategy(sortingType, this.model, dataType);
        this.printingStrategy = PrinterFactory.createPrintingStrategy(outputDest, sortingType, dataType);
    }

    class InputReaderFactory {
        public static Reader createInputReader(String dataType, String filePath) {
            if ("System.in".equals(filePath)) {
                switch (dataType) {
                    case "long":
                        return new ReadEnterLongs();
                    case "line":
                        return new ReadEnterLines();
                    case "word":
                        return new ReadEnterWords();
                    default:
                        throw new IllegalArgumentException("Invalid data type!");
                }
            } else {
                switch (dataType) {
                    case "long":
                        return new ReadLongsFile(filePath);
                    case "line":
                        return new ReadLinesFile(filePath);
                    case "word":
                        return new ReadWordsFile(filePath);
                    default:
                        throw new IllegalArgumentException("Invalid data type!");
                }
            }
        }
    }

    class SortingStrategyFactory {
        public static SortingStrategy createSortingStrategy(String sortingType, NumData model, String dataType) {
            if ("natural".equals(sortingType)) {
                return switch (dataType) {
                    case "long" -> new SortingLongsNatural();
                    case "line" -> new SortingLinesNatural();
                    case "word" -> new SortingWordsNatural();
                    default -> throw new IllegalArgumentException("Invalid data type!");
                };
            } else if ("byCount".equals(sortingType)) {
                return switch (dataType) {
                    case "long" -> new SortingLongsByCount();
                    case "line" -> new SortingLinesByCount();
                    case "word" -> new SortingWordsByCount();
                    default -> throw new IllegalArgumentException("Invalid data type!");
                };
            } else {
                throw new IllegalArgumentException("Invalid sorting type!");
            }
        }
    }

    class PrinterFactory {
        public static Printer createPrintingStrategy(String outputDest, String sortingType, String dataType) {
            if ("CommandLine".equals(outputDest)) {
                if ("natural".equals(sortingType)) {
                    return switch (dataType) {
                        case "long" -> new PrintingLongsNatural();
                        case "line" -> new PrintingLinesNatural();
                        case "word" -> new PrintingWordsNatural();
                        default -> throw new IllegalArgumentException("Invalid data type!");
                    };
                } else if ("byCount".equals(sortingType)) {
                    return switch (dataType) {
                        case "long" -> new PrintingLongsByCount();
                        case "line" -> new PrintingLinesByCount();
                        case "word" -> new PrintingWordsByCount();
                        default -> throw new IllegalArgumentException("Invalid data type!");
                    };
                } else {
                    throw new IllegalArgumentException("Invalid sorting type!");
                }
            } else {
                if ("byCount".equals(sortingType)) {
                    return new WritingLinesByCount();
                } else if ("natural".equals(sortingType)) {
                    return new WritingLinesNatural();
                } else {
                    throw new IllegalArgumentException(outputDest + " is invalid.");
                }
            }
        }
    }



    private NumData getModelByDataType(String dataType) {
        switch (dataType) {
            case "long":
                return new NumDataLongs();
            case "line":
                return new NumDataLines();
            case "word":
                return new NumDataWords();
            default:
                throw new IllegalArgumentException("Invalid data type!");
        }
    }

    public NumData readInput() {
        if (this.configs.inputDest.equals("System.in")) {
            return readInputStrategy.read();
        } else {
            return readInputStrategy.read(configs.inputDest);
        }

    }

    public NumData sort() {
        return sortingStrategy.sort(model);
    }

    public NumData sort(NumData data) {
        return sortingStrategy.sort(data);
    }

    public void print() {
        printingStrategy.print(model);
    }

    public void print(NumData data) throws IOException {
        if (configs.getOutputDest().equals("CommandLine")) {
            printingStrategy.print(data);
        } else {
            printingStrategy.print(data, configs.getOutputDest());
        }
    }

}
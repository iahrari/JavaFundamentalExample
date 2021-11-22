package com.github.iahrari.javaFundamental.tryWithResources;
import com.github.iahrari.javaFundamental.util.FileUtils;

public class App {
    public static void main(String[] args) {
        String inputFile = FileUtils.getFileName(args, 0, "input file");
        String outputFile = FileUtils.getFileName(args, 1, "output file");

        DataManipulator reader = new DataManipulator(inputFile, outputFile);
        reader.run();
        
        System.out.printf("\nData that was found in %s: \n", inputFile);
        reader.getData().forEachRemaining(System.out::println);
    }
}
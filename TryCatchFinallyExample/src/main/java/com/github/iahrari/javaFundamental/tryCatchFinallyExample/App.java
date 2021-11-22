package com.github.iahrari.javaFundamental.tryCatchFinallyExample;

import com.github.iahrari.javaFundamental.util.CodeUtils;
import com.github.iahrari.javaFundamental.util.FileUtils;

public class App {
    public static void main(String[] args) {
        String file = FileUtils.getFileName(args, 0, "input file");
        
        DataReader reader = new DataReader(file);
        CodeUtils.measureExecutionTime(reader::run);

        System.out.printf("\n%s's data: \n", file);
        reader.getData().forEachRemaining(System.out::println);
    }    
}

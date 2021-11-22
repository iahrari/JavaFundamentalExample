package com.github.iahrari.javaFundamental.util;

public class CodeUtils {
    public static void measureExecutionTime(MeasureTimeSam executable){
        long millis = System.currentTimeMillis();
        executable.execute();
        System.out.println("Running time: " + (System.currentTimeMillis() - millis));
    }

    public interface MeasureTimeSam{
        void execute();
    }
}

package com.github.iahrari.javaFundamental.util;

import java.util.Scanner;

public class FileUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getFileName(String[] args, int index, String type){
        String file;

        if(args.length <= index){
            System.out.println("\nPlease enter the " + type + " file location: ");
            file = scanner.nextLine();
        } else file = args[index];

        return file;
    }
}

package com.github.iahrari.javaFundamental.tryCatchFinallyExample;

import com.github.iahrari.javaFundamental.util.AbstractDataReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader extends AbstractDataReader<String> {

    public DataReader(String readFromFile){
        super(readFromFile);
    }

    @Override
    public void run(){

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(readFromFile));
            readLine(reader);
        } catch (FileNotFoundException e) {
            System.err.printf("\nCouldn't find the %s\n", readFromFile);
        }
        finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Couldn't close the file buffer.");
                }
            }
        }

        System.out.printf("\nSize of data is: %d\n", data.size());
    }

    private void readLine(BufferedReader reader){
        String line;
        while(true) {
            try {
                line = reader.readLine();
                if (line == null) break;
                data.add(line);
            } catch (IOException e) {
                System.err.println("Can't read the line.");
            }
        }
    }
}

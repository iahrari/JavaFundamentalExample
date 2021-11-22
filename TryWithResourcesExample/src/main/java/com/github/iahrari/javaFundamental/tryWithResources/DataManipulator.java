package com.github.iahrari.javaFundamental.tryWithResources;

import com.github.iahrari.javaFundamental.util.AbstractDataReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManipulator extends AbstractDataReader<Integer> {
    private final String writeToFile;

    public DataManipulator(String readFromFile, String writeToFile){
        super(readFromFile);
        this.writeToFile = writeToFile;
    }

    @Override
    public void run(){
        try(
            BufferedReader reader = new BufferedReader(new FileReader(readFromFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(writeToFile))
        ) {
            readInt(writer, reader);
        } catch (FileNotFoundException e) {
            System.err.printf("\nCouldn't find %s\n", readFromFile);
        } catch (IOException e) {
            System.err.printf("Couldn't write to %s\n", writeToFile);
        }

        if (!data.isEmpty()) 
            System.out.printf("\nCorrect file is saved at %s", writeToFile);
    }

    private void readInt(BufferedWriter writer, BufferedReader reader){
        int index = 0;
        String line;
        while(true) {
            try {
                line = reader.readLine();
                if (line == null) break;
                boolean isNotRepeated = data.add(convertStringToInt(line, ++index));
                
                if(isNotRepeated) {
                    if (index != 1) writer.append("\n");
                    writer.append(line);
                }
            } catch (WrongDataTypeException e) {
                System.err.printf(
                        "Couldn't convert '%s' from line: %d\n",
                        e.getData(),
                        e.getLineNumber()
                );
            } catch (IOException e){
                System.err.printf("\nCouldn't read or write: \n%s\n", e.getMessage());
            }
        }
    }

    private int convertStringToInt(String data, int index)
            throws WrongDataTypeException {
        int convertedInteger;
        try {
            convertedInteger = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new WrongDataTypeException(data, index,
                    String.format("Couldn't convert '%s' from line: %d\n", data, index), e);
        }
        return convertedInteger;
    }
}

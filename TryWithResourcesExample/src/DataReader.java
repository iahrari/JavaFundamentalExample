import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataReader {
    private final Set<Integer> data;
    private final String readFromFile;
    private final String writeToFile;

    DataReader(String readFromFile, String writeToFile){
        data = new HashSet<>();
        this.readFromFile = readFromFile;
        this.writeToFile = writeToFile;
    }

    public Iterator<Integer> getData(){
        return data.iterator();
    }

    public void run(){
        try(
            BufferedReader reader = new BufferedReader(new FileReader(readFromFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(writeToFile))
        ) {
            readLine(writer, reader, data);
        } catch (FileNotFoundException e) {
            System.err.printf("\nCouldn't find %s\n", readFromFile);
        } catch (IOException e) {
            System.err.printf("Couldn't write to %s\n", writeToFile);
        } finally {
            if (!data.isEmpty()) {
                System.out.printf("\nCorrect file is saved at %s", writeToFile);
            }
        }
    }

    private void readLine(
            BufferedWriter writer,
            BufferedReader reader,
            Set<Integer> data
    ){
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

    private int convertStringToInt(
            String data, int index
    ) throws WrongDataTypeException {
        int integer;
        try {
            integer = Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new WrongDataTypeException(
                data, 
                "Data in line " + index + " is not a correct number", 
                index, e
            );
        }
        return integer;
    }
}

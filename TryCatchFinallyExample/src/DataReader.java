import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataReader {
    private final Set<String> data;
    private final String readFromFile;

    DataReader(String readFromFile){
        data = new HashSet<>();
        this.readFromFile = readFromFile;
    }

    public Iterator<String> getData(){
        return data.iterator();
    }

    public void run(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(readFromFile));
            readLine(reader, data);
        } catch (FileNotFoundException e) {
            System.err.printf("\nCouldn't find the %s\n", readFromFile);
        } finally {
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

    private void readLine(BufferedReader reader, Set<String> data){
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<String> data = new HashSet<>();
        String file = getFileName(args);
 
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            readLine(reader, data);
        } catch (FileNotFoundException e) {
            System.err.printf("\nCouldn't find the %s\n", file);
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Couldn't close the file buffer.");
                }
            }
        }

        if (!data.isEmpty())
                System.out.printf("\n%s's data: \n", file);
        data.forEach(System.out::println);
        System.out.printf("\nSize of data is: %d\n", data.size());
    }

    public static String getFileName(String[] args){
        String file;
        if(args.length == 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the file location: ");
            file = scanner.nextLine();
            scanner.close();
        } else {
            file = args[0];
        }

        return file;
    }

    public static void readLine(BufferedReader reader, Set<String> data){
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

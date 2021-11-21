import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Set<Integer> data = new HashSet<>();
        String file = getFileName(args, 0, "start");
        String correctFileName = getFileName(args, 1, "saved");

        try(
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(correctFileName))
        ) {
            readLine(writer, reader, data);
        } catch (FileNotFoundException e) {
            System.err.printf("\nCouldn't find %s\n", file);
        } catch (IOException e) {
            System.err.println("Couldn't read specific line \n" + e.getMessage());
        } finally {
            if (!data.isEmpty()) {
                System.out.printf("\n%s's data: \n", file);
                data.forEach(System.out::println);
                System.out.printf("\nCorrect file is saved at %s", correctFileName);
            }
        }

        scanner.close();
    }

    public static String getFileName(String[] args, int index, String type){
        String file;

        if(args.length <= index){
            System.out.println("\nPlease enter the " + type + " file location: ");
            file = scanner.nextLine();  
        } else file = args[index];

        return file;
    }

    public static void readLine(
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
                data.add(convertStringToInt(line, ++index));
                if (index != 1) writer.append("\n");
                writer.append(line);
            } catch (WrongDataTypeException e) {
                System.err.printf(
                        "Couldn't convert '%s' from line: %d\n",
                        e.getData(),
                        e.getLineNumber()
                );
            } catch (IOException e){
                System.err.printf("\nCouldn't read or write: \n%s", e.getMessage());
            }
        }
    }

    public static int convertStringToInt(
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
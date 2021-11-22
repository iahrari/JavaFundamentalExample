import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String file = getFileName(args, 0, "start");
        String correctFileName = getFileName(args, 1, "saved");

        DataReader reader = new DataReader(file, correctFileName);
        reader.run();
        
        System.out.printf("\nInteger data that was found in %s: \n", file);
        reader.getData().forEachRemaining(System.out::println);
        
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

}
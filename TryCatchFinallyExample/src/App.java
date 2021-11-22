import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String file = getFileName(args);
        
        DataReader reader = new DataReader(file);
        reader.run();

        System.out.printf("\n%s's data: \n", file);
        reader.getData().forEachRemaining(System.out::println);
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
}

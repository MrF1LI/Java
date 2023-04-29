import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class FileUtils {

    private FileUtils(){}

    public static void createFile() throws IOException {

        File file = new File("Luka.txt");
        if(file.createNewFile()) {
            System.out.println("File Created : " + file.getName());
        } else {
            System.out.println("Already exists");
        }

    }

    public static void writeInFile(String data) throws IOException {
        FileWriter fileWriter = new FileWriter("Luka.txt");
        fileWriter.write(data);
        fileWriter.flush();
    }

    public static void readFromFile() throws FileNotFoundException {
        File file = new File("Luka.txt");

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }

    public static void deleteFile() {
        File file = new File("Luka.txt");
        if (file.delete()){
            System.out.println("File has been deleted");
        } else {
            System.out.println("File doesn't exists");
        }
    }

}

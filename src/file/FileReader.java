package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static String read(){
        String str = "";
        try {
            File myObj = new File("D:\\КН-303\\II semester\\Технології розподілених систем та паралельних обчислень\\Lab_1\\src\\Text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                str = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return str;
    }
}

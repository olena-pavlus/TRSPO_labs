package thread.multi;

import file.FileReader;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Multi {
    public static void main(String[] args) throws InterruptedException {

        String str = FileReader.read();
        int numberOfThreads = 4;
        String findStr = "hello";
        long time = System.currentTimeMillis();
        findElement(numberOfThreads, findStr, str);
        System.out.println("\nTime - " + (double) (System.currentTimeMillis() - time));
    }

    private static void findElement(int numberOfThreads, String findStr, String str) throws InterruptedException {

        int sizeOfStr = str.length();
        int sizeOfFindStr = findStr.length();
        int range = sizeOfStr/numberOfThreads;
        String substr;
        Thread searcher = null;

        for (int i = 0; i <= numberOfThreads-1; i++) {
            
            if (i == numberOfThreads-1) {
                substr = str.substring(i*range, sizeOfStr);
                searcher = new Thread(new Searcher(findStr, substr, i, range));

            } else {
                substr = str.substring(i*range, i*range+range-1 + (sizeOfFindStr - 1));
                searcher = new Thread(new Searcher(findStr, substr, i, range));

            }
            searcher.start();
        }
        assert searcher != null;
        searcher.join();

    }
}

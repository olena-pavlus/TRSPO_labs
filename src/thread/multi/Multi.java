package thread.multi;

import file.FileReader;

public class Multi {
    public static void main(String[] args) throws InterruptedException {

        String str = FileReader.read();
        int numberOfThreads = 4;
        String findStr = "hello";
        findElement(numberOfThreads, findStr, str);
    }

    private static void findElement(int numberOfThreads, String findStr, String str) throws InterruptedException {

        int sizeOfStr = str.length();
        int sizeOfFindStr = findStr.length();
        int range = sizeOfStr/numberOfThreads;
        String substr;
        //Thread searcher = null;
        Thread[] searcher = new Thread[numberOfThreads];
        long time = System.currentTimeMillis();
        for (int i = 0; i <= numberOfThreads-1; i++) {

            if (i == numberOfThreads-1) {
                substr = str.substring(i*range, sizeOfStr);
                searcher[i] = new Thread(new Searcher(findStr, substr, i, range));

            } else {
                substr = str.substring(i*range, i*range+range-1 + (sizeOfFindStr - 1));
                searcher[i] = new Thread(new Searcher(findStr, substr, i, range));

            }
            searcher[i].start();
            //searcher[i].join();
        }
        long time2 = System.currentTimeMillis() - time;
        for (int i = 0; i <= numberOfThreads-1; i++) {
            searcher[i].join();
        }
        System.out.println("\nTime - " + (double) time2);
    }
}

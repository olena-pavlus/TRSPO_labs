package thread.multi;

import java.util.ArrayList;

public class Searcher implements Runnable {
    private String stringToFind;
    private String subString;
    private int lastIndex = 0;
    private int rangeOfThread;
    private int index;
    private int result = 0;

    public Searcher(String findStr, String substr, int i, int range) {
        stringToFind = findStr;
        subString = substr;
        index = i;
        rangeOfThread = range;
    }

    public void run() {
        while (lastIndex != -1) {
            lastIndex = subString.indexOf(stringToFind, lastIndex);
            if (lastIndex != -1) {
                result = lastIndex + rangeOfThread * index;
                System.out.print(result + " ");
                lastIndex += 1;
            }
        }
    }
}

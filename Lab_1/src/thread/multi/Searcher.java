package thread.multi;


public class Searcher implements Runnable {
    private final String stringToFind;
    private final String subString;
    private int lastIndex = 0;
    private final int rangeOfThread;
    private final int index;

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
                int result = lastIndex + rangeOfThread * index;
                System.out.print(result + " ");
                lastIndex += 1;
            }
        }
    }
}

package thread.single;
import file.FileReader;

public class EasySearcher {
    public static void main(String [] args) {
        String str = FileReader.read();
        String findStr = "hello";
        int lastIndex = 0;

        long time = System.currentTimeMillis();

        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {

                System.out.print(lastIndex + " ");
                lastIndex += 1;
            }
        }

        System.out.println("\nTime - " + (double) (System.currentTimeMillis() - time));

    }
}

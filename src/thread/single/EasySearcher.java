package thread.single;
import file.FileReader;


public class EasySearcher {
    public static void main(String [] args) {
        String str = FileReader.read();
        String findStr = "hello";
        int lastIndex = 0;
        //List<Integer> result = new ArrayList<>();
        long time = System.currentTimeMillis();

        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                //result.add(lastIndex);
                System.out.println(lastIndex);
                lastIndex += 1;
            }
        }

        System.out.println("Time - " + (double) (System.currentTimeMillis() - time));

    }
}

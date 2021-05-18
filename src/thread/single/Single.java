package thread.single;

import file.FileReader;



public class Single {

    public static void main (String[] args){
        String str = FileReader.read();
        int numberOfThreads = 10;
        String findStr = "hello";
        long time = System.currentTimeMillis();
        findElement(numberOfThreads, findStr, str);
        System.out.println("Time - " + (double) (System.currentTimeMillis() - time));
    }

    private static void findElement(int numberOfThreads, String findStr, String str) {
        int sizeOfStr = str.length();
        int sizeOfFindStr = findStr.length();
        int range = sizeOfStr/numberOfThreads;
        String substr;
        int result;
        int lastIndex;
        //ArrayList<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i <= numberOfThreads-1; i++) {
            lastIndex = 0;
            if (i == numberOfThreads-1) {
                substr = str.substring(i*range, sizeOfStr);
                while (lastIndex != -1) {
                    lastIndex = substr.indexOf(findStr, lastIndex);
                    if (lastIndex != -1) {
                        result = lastIndex + range * i;
                        //results.add(result);
                        System.out.println(result);
                        lastIndex += 1;
                    }
                }
            } else {
                substr = str.substring(i*range, i*range+range-1 + sizeOfFindStr);
                while (lastIndex != -1) {
                    lastIndex = substr.indexOf(findStr, lastIndex);
                    if (lastIndex != -1) {
                        result = lastIndex + range * i;
                        System.out.println(result);
                        //results.add(result);
                        lastIndex += 1;
                    }
                }
            }

        }
        //return results;
    }
}


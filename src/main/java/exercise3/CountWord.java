package exercise3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWord {
    public static final String FILE_NAME = "words.txt";
    public static void main(String[] args) {
        String[] words = readFromFile(FILE_NAME);
        System.out.println(countWords(words));

    }
    public static String countWords(String[] words){

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if(hashMap.containsKey(words[i]))
                continue;
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if(words[i].equals(words[j]))
                    count++;
            }

            hashMap.put(words[i],count);
        }
        entriesSortedByValues(hashMap);

        StringBuilder result = new StringBuilder();
        for (var key : hashMap.keySet().toArray()) {
            result.append(key).append(" ").append(hashMap.get(key)).append("\n");
        }
        return result.toString();
    }
    static <K,V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Map.Entry<K,V>> sortedEntries = new ArrayList<Map.Entry<K,V>>(map.entrySet());

        Collections.sort(sortedEntries,
                new Comparator<Map.Entry<K,V>>() {
                    @Override
                    public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortedEntries;
    }
    public static String[] readFromFile(String fileName){
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }

            return stringBuilder.toString().split(" ");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

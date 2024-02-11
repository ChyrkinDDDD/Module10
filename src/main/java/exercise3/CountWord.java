package exercise3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountWord {
    public static final String FILE_NAME = "words.txt";
    public static void main(String[] args) {
        String[] words = readFromFile(FILE_NAME);
        System.out.println(countWords(words));

    }
    public static String countWords(String[] words){
        
        List<String> list = new ArrayList<>();
        for (var word : words) {
            if(list.contains(word))continue;

            list.add(word);
        }
        HashMap<Integer,String> hashMap = new HashMap<>();

        for (var word : list) {
            int count = 0;
            for (var value: words) {
                if(word.equals(value))
                    count++;
            }
            hashMap.put(count,word);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = hashMap.size()-1; i >= 0; i--) {
            stringBuilder.append(hashMap.values().toArray()[i]).append(" ")
                    .append(hashMap.keySet().toArray()[i]).append("\n");
        }

        return stringBuilder.toString();
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

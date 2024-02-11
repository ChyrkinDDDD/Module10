package exercise1;

import java.io.*;
import java.util.regex.*;

public class ReadNumber {
    public static void main(String[] args) {
        File numbers = new File("Numbers.txt");
        numberReader(numbers);
    }

    public static void numberReader(File file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            final String NUMBER_REGEX = "(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})";

            Pattern pattern = Pattern.compile(NUMBER_REGEX);
            Matcher matcher = pattern.matcher(stringBuilder.toString());

            while (matcher.find()){
                String result = matcher.group();
                System.out.println(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

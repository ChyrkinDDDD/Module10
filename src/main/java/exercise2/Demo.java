package exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static final String FILE_NAME = "file.txt";
    public static void main(String[] args) {
        String[] dataFromFile = readFromFile(FILE_NAME);
        List<User> users = fillList(dataFromFile);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        jsonWriter(json);
    }
    public static void jsonWriter(String data){
        try (FileOutputStream fos = new FileOutputStream("user.json");
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));){
            bufferedWriter.write(data);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public static List<User> fillList(String[] dataFromFile){
        List<User> result = new ArrayList<>();
        for(int i = 2; i < dataFromFile.length; i+=2){
            String name = dataFromFile[i];
            int age = Integer.parseInt(dataFromFile[i+1]);
            result.add(new User(name,age));
        }
        return result;
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

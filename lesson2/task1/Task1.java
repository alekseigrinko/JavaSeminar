package javaseminar.lesson2.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Task1 {
    public static void main(String[] args) {
        String path = "D:\\GB\\HW\\javaseminar\\lesson2\\task1\\input.txt"; //путь к файлу
        File file = new File(path); //использовал файл, так как не сохраняется в String предложенная строка
        Task1 task1 = new Task1();
        
        System.out.println(task1.parsingLine(task1.inputString(file))); 
    }
    
    String inputString(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader (file));
            String line = null;
            StringBuilder  stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e){
            return e.getMessage();
        }
    }

    private String cutLine(String str) {
        if (str.contains("\n")) {
            return str.substring(1, str.length() - 3);
        } else {
            return str.substring(1, str.length() - 1);
        }
    }

    private String toSQL(String str) {
        String[] arr = str.split(":");
        if (cutLine(arr[1]).equals("null")) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cutLine(arr[0]) + "=" + cutLine(arr[1]));
            return stringBuilder.toString();
        }
    }

    String parsingLine(String str) {
        StringBuilder stringBuilder = new StringBuilder("select * from students WHERE ");
        String[] arr = cutLine(str).split(", ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].contains("null")) {
                if (count > 0) {
                    stringBuilder.append(" AND ");
                } else {
                    count++;
                }
            }
            stringBuilder.append(toSQL(arr[i]));
        }
        return stringBuilder.toString();
    }
}
package javaseminar.lesson2.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Task3 {
    public static void main(String[] args) {
        String path = "D:\\GB\\HW\\javaseminar\\lesson2\\task3\\input.txt"; //путь к файлу
        File file = new File(path);
        Task3 task3 = new Task3();
        System.out.println(task3.parsingLine(task3.inputString(file))); 
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

    private String toLine(String str) {
        String[] arr = str.split(","); //["фамилия":"Петрова","оценка":"4","предмет":"Информатика"] строка разбилась на три элемента
        String surname = cutLine(arr[0].split(":")[1]);
        String grade = cutLine(arr[1].split(":")[1]);
        String subject = cutLine(arr[2].split(":")[1]);
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Студент " + surname + " получил " + grade + " по предмету " + subject + ".").toString();
    }

    String parsingLine(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        str = str.replace("},{", "//");
        String[] arr = cutLine(str).split("//");
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(toLine(arr[i]));
            if (i != arr.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
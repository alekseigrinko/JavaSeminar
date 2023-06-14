package javaseminar.lesson2.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task4 task4 = new Task4();
        System.out.println("Задайте уравнение вида q + w = e, где q, w, e >= 0:");
        String line = scanner.nextLine();
        System.out.println(task4.getResult(line));
    }

    String getResult(String line) {
        String message = "Нет доступных вариантов решения уровнения";
        Logger logger = Logger.getLogger(Task4.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("D:\\GB\\HW\\javaseminar\\lesson2\\task4\\log.txt", 10000, 1, false);
            logger.addHandler(fileHandler);
            SimpleFormatter sFormatter = new SimpleFormatter();
            fileHandler.setFormatter(sFormatter);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        logger.log(Level.INFO, "Задано уравнение: " + line);
        for (int i = 1; i < 10; i++) {
            String result = line.replace("?", Integer.toString(i));
            String[] arr = result.split(" ");
            if (Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4])) {
                message = result;
            }
        }
    logger.log(Level.INFO, message);    
    return message;
    }
}

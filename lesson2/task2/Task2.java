package javaseminar.lesson2.task2;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 2};
        Task2 task2 = new Task2();
        System.out.println("Итоговый результат сортировки: " + task2.printArray(task2.bubbleSort(arr)));
    }

    int[] bubbleSort(int[] arr) {
        Logger logger = Logger.getLogger(Task2.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("D:\\GB\\HW\\javaseminar\\lesson2\\task2\\log.txt", 10000, 1, false);
            logger.addHandler(fileHandler);
            SimpleFormatter sFormatter = new SimpleFormatter();
            fileHandler.setFormatter(sFormatter);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        int[] sortArr = arr;
        boolean check = true;
        while (check) {
            int count = 0;
            for (int i = 0; i < (sortArr.length - 1); i++) {
                if(arr[i] > sortArr[i+1]) {
                    int a = sortArr[i];
                    int b = sortArr[i+1];
                    sortArr[i] = b;
                    sortArr[i+1] = a;
                    count++;
                }
            }
            if (count == 0) {
                check = false;
            } else {
                logger.log(Level.INFO, "Результат предварительной сортировки: " + printArray(sortArr));
            }
        }
    logger.log(Level.INFO,"Итоговый результат сортировки: " + printArray(sortArr));
    return sortArr;
    }

    String printArray (int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
            if (i != arr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}

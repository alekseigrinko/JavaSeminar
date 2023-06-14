package javaseminar.lesson2.task4;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
    public static void main(String[] args) {
        Task4 task4 = new Task4();
        task4.getTask3(task4);
    }

    void getTask3(Task4 task4) { // реалиация калькулятора с логированием
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int number2 = scanner.nextInt();
        System.out.println("Введите знак арифметического действия (+ - * /): ");
        String sign = scanner.next();
        task4.calculation(number1, number2, sign);
    }

    private void calculation (int number1, int number2, String sign) {
        Logger logger = Logger.getLogger(Task4.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("D:\\GB\\HW\\javaseminar\\lesson2\\task4\\log.txt", 10000, 1, true);
            logger.addHandler(fileHandler);
            SimpleFormatter sFormatter = new SimpleFormatter();
            fileHandler.setFormatter(sFormatter);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        if (sign.equals("+")) {
            logger.log(Level.INFO, number1 + sign + number2 + "=" + (number1 + number2));
            System.out.println(number1 + sign + number2 + "=" + (number1 + number2));
        } else if (sign.equals("-")) {
            logger.log(Level.INFO, number1 + sign + number2 + "=" + (number1 - number2));
            System.out.println(number1 + sign + number2 + "=" + (number1 - number2));
        } else if (sign.equals("*")) {
            logger.log(Level.INFO, number1 + sign + number2 + "=" + (number1 * number2));
            System.out.println(number1 + sign + number2 + "=" + (number1 * number2));
        } else if (sign.equals("/")) {
            logger.log(Level.INFO, number1 + sign + number2 + "=" + ((double)number1 / number2));
            System.out.println(number1 + sign + number2 + "=" + ((double)number1 / number2));
        } else {
            logger.log(Level.INFO, "Такая операция не поддерживается");
            System.out.println("Такая операция не поддерживается");
        }
    }

    void getTask4(Task4 task4) { //перепутал с калькулятором, реализовал условие задачи для дополнительного задания предыдущего урока
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте уравнение вида q + w = e, где q, w, e >= 0:");
        String line = scanner.nextLine();
        System.out.println(task4.getResult(line));
    }

    private String getResult(String line) {
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

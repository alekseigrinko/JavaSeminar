package javaseminar.lesson1.task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task1 task1 = new Task1();
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        System.out.println("Треугольное число от числа " + number + ": " + task1.getTerangularNumber(number) + "\n"
        + "Факториал числа " + number + ": " + task1.getFactorial(number));
    }

    int getTerangularNumber (int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += i;
        }
        return count;
    }

    double getFactorial (int number) {
        double count = 1;
        for (int i = 2; i <= number; i++) {
            System.out.println(count);
            count *= i;
        }
        System.out.println(count);
        return count;
    }
}

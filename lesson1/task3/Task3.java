package javaseminar.lesson1.task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task3 task3 = new Task3();
        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int number2 = scanner.nextInt();
        System.out.println("Введите знак арифметического действия (+ - * /): ");
        String sign = scanner.next();
        task3.func(number1, number2, sign);
    }

    void func(int number1, int number2, String sign) {
        if (sign.equals("+")) {
            System.out.println(number1 + sign + number2 + "=" + (number1 + number2));
        } else if (sign.equals("-")) {
            System.out.println(number1 + sign + number2 + "=" + (number1 - number2));
        } else if (sign.equals("*")) {
            System.out.println(number1 + sign + number2 + "=" + (number1 * number2));
        } else if (sign.equals("/")) {
            System.out.println(number1 + sign + number2 + "=" + ((double)number1 / number2));
        } else {
            System.out.println("Такая операция не поддерживается");
        }
    }
}

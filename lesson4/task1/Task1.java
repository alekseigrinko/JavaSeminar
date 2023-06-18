package javaseminar.lesson4.task1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        Deque num1 = task1.getDeque(scanner.nextLine());
        System.out.println("Введите второе число:");
        Deque num2 = task1.getDeque(scanner.nextLine());
        System.out.println("Полльзователем заданы следующие числа в формате Deque в обратном порядке:\n" 
        + num1.toString() + "\n" + num2.toString());
        System.out.println("1. Умножение двух чисел в виде связанного списка равно: " + task1.getMulti(num1, num2) + ".");
        System.out.println("2. Сложение двух чисел в виде связанного списка равно: " + task1.getSum(num1, num2) + ".");
    }

    Deque getDeque(String num) { // нужно задать необходимое число
        Deque<Character> dequeList = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            dequeList.addFirst(num.charAt(i));
        }
        return dequeList;
    }

    Integer getNum(Deque num) {
        StringBuilder sb = new StringBuilder();
        num.descendingIterator().forEachRemaining(ch -> sb.append(String.valueOf(ch)));
        return Integer.parseInt(sb.toString());
    }

    Deque getAnswer(String num) { // нужно задать необходимое число
        Deque<Character> dequeList = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            dequeList.add(num.charAt(i));
        }
        return dequeList;
    }

    Deque getMulti(Deque num1, Deque num2) {
        int n1 = getNum(num1);
        int n2 = getNum(num2);
        return getAnswer(String.valueOf(n1 * n2));
    }

    Deque getSum(Deque num1, Deque num2) {
        int n1 = getNum(num1);
        int n2 = getNum(num2);
        return getAnswer(String.valueOf(n1 + n2));
    }
}

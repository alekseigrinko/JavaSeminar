package javaseminar.lesson1.task2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task2 task2 = new Task2();
        System.out.println("Все простые числа от 1 до 1000: " + task2.getNumbers());
    }

    List getNumbers () {
        List list = new ArrayList<Integer>();
        for (int i = 1; i <= 1000; i++) {
            if (checkNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean checkNumber(int number) {
        boolean check = true;
        for (int i = 2; i < number; i++) {
            if (number%i == 0) {
                check = false;
                break;
            }
        } 
        return check;
    }
    
}

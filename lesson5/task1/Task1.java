package javaseminar.lesson5.task1;

import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.start();
    }

    void start() {
        Scanner scanner = new Scanner(System.in, "CP866");
        TreeMap<Integer, String> book = new TreeMap<>();
        while (true) {
            menu();
            int command = command(scanner);
            if (command == 1) {
                addTelephone(book, scanner);
            } else if (command == 2) {
                getBook(book);
            } else if (command == 3) {
                removeTelephone(book, scanner);
            } else if (command == 0) {
                System.out.println("Выход из меню.");
                break;
            } else {
                System.out.println("Некорректная команда, попробуйте ещё раз.");
            }
        }
    }

    void menu () {
        System.out.println("--------------------------------------------");
        System.out.println("Введите команду:");
        System.out.println("1 - Добавить телефон в записную книгу");
        System.out.println("2 - Показать телефонную книгу");
        System.out.println("3 - Удалить телефон из записной книги");
        System.out.println("0 - Выход");
        System.out.println("--------------------------------------------");
    }

    private static int command(Scanner scanner) {
        int command;
        while (true) {
            if (scanner.hasNextInt()) {
                command = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректное значение, необходимо ввести число!");
                scanner.next();
            }
        }
        return command;
    }

    private void addTelephone(TreeMap<Integer, String> book, Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите номер телефона:");
        int number = scanner.nextInt();
        book.put(number, name);
    }

    private void getBook(TreeMap<Integer, String> book) {
        List<String> names = (List)book.values().stream().distinct().collect(Collectors.toList());
        for (String name : names) {
            for (Integer n : book.keySet()) {
                if (book.get(n).equals(name)) {
                    System.out.println(name + " " + n);
                }
            }
        }
    }

    private void removeTelephone(TreeMap<Integer, String> book, Scanner scanner) {
        System.out.println("Введите номер телефона для удаления:");
        int number = scanner.nextInt();
        book.remove(number);
    }
}

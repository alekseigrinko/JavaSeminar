package javaseminar.lesson6.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import javaseminar.lesson6.task1.model.Laptop;
import javaseminar.lesson6.task1.model.Parameter;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in, "CP866");
        Parameter parameter = new Parameter();
        List<Laptop> listLaptops = addLaptops(random.nextInt(30), parameter);
        while (true) {
            menu();
            int command = command(scanner);
            if (command == 1) {
                getLaptopsByOS(listLaptops, parameter, scanner);
            } else if (command == 2) {
                getLaptopsByRAM(listLaptops, parameter, scanner);
            } else if (command == 3) {
                getLaptopsByHDD(listLaptops, parameter, scanner);
            } else if (command == 4) {
                getLaptopsByColor(listLaptops, parameter, scanner);
            } else if (command == 0) {
                System.out.println("Выход из меню.");
                break;
            } else {
                System.out.println("Некорректная команда, попробуйте ещё раз.");
            }
        }
    }

    List<Laptop> addLaptops(int num, Parameter parameter) { // создаёт список ноутбуков
        List<Laptop> listLaptops = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            listLaptops.add(new Laptop(parameter));
        }
        System.out.println("Имеется в наличии " + num + " ноутбука(-ов)");
        return listLaptops;
    }

    void menu () {
        System.out.println("--------------------------------------------");
        System.out.println("Добро пожаловать в поисковик ноутбуков!");
        System.out.println("Введите параметр для отбора ноутбука:");
        System.out.println("1 - Операционна система");
        System.out.println("2 - RAM");
        System.out.println("3 - HDD");
        System.out.println("4 - Цвет");
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

    private void getLaptopsByOS(List<Laptop> list, Parameter parameter, Scanner scanner) {
        System.out.println("Введите номер с искомой системой:");
        for (int i = 0; i < parameter.getListOS().size(); i++) {
            System.out.println((i + 1) + ": " + parameter.getListOS().get(i));
        }
        int command = command(scanner);
        list = list.stream().filter(l -> l.getOs().equals(parameter.getListOS().get(command - 1))).collect(Collectors.toList());
        System.out.println("Согласно запросу найдено " + list.size() + " ноутбука(-ов):");
        list.stream().forEach(l -> System.out.println(l.toString()));
    }

    private void getLaptopsByRAM(List<Laptop> list, Parameter parameter, Scanner scanner) {
        System.out.println("Введите номер необходимым значением RAM:");
        for (int i = 0; i < parameter.getListRAM().size(); i++) {
            System.out.println((i + 1) + ": " + parameter.getListRAM().get(i));
        }
        int command = command(scanner);
        list = list.stream().filter(l -> l.getRAM() == parameter.getListRAM().get(command - 1)).collect(Collectors.toList());
        System.out.println("Согласно запросу найдено " + list.size() + " ноутбука(-ов):");
        list.stream().forEach(l -> System.out.println(l.toString()));
    }

    private void getLaptopsByHDD(List<Laptop> list, Parameter parameter, Scanner scanner) {
        System.out.println("Введите номер необходимым значением HDD:");
        for (int i = 0; i < parameter.getListHDD().size(); i++) {
            System.out.println((i + 1) + ": " + parameter.getListHDD().get(i));
        }
        int command = command(scanner);
        list = list.stream().filter(l -> l.getHDD() == parameter.getListHDD().get(command - 1)).collect(Collectors.toList());
        System.out.println("Согласно запросу найдено " + list.size() + " ноутбука(-ов):");
        list.stream().forEach(l -> System.out.println(l.toString()));
    }

    private void getLaptopsByColor(List<Laptop> list, Parameter parameter, Scanner scanner) {
        System.out.println("Введите номер необходимым цветом:");
        for (int i = 0; i < parameter.getListColors().size(); i++) {
            System.out.println((i + 1) + ": " + parameter.getListColors().get(i));
        }
        int command = command(scanner);
        list = list.stream().filter(l -> l.getColor().equals(parameter.getListColors().get(command - 1))).collect(Collectors.toList());
        System.out.println("Согласно запросу найдено " + list.size() + " ноутбука(-ов):");
        list.stream().forEach(l -> System.out.println(l.toString()));
    }
}

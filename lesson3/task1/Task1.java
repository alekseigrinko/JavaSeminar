package javaseminar.lesson3.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        List list = task1.getList(20);
        System.out.println("Сгенерирован произвольный список чисел:\n" + list);
        list = task1.removeEvenNumbers(list);
        System.out.println("Удалили из него все чётный числа:\n" + list);
        System.out.println("Максимальное значение в оставшемся списке:\n" + task1.getMax(list));
        System.out.println("Минимальное значение в оставшемся списке:\n" + task1.getMin(list));
        System.out.println("Среднее значение в оставшемся списке:\n" + task1.getAvarage(list));
    }

    List getList(int length) { // нужно задать необходимую длину генерируемого списка
        Random random = new Random();
        List list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }

    List removeEvenNumbers(List<Integer> list) {
        return list
        .stream()
        .filter(num -> num % 2 != 0)
        .collect(Collectors.toList());
    }

    int getMax(List<Integer> list) {
        return list.stream().mapToInt(n -> n).max().orElseThrow(NoSuchElementException::new);
    }

    int getMin(List<Integer> list) {
        return list.stream().mapToInt(n -> n).min().orElseThrow(NoSuchElementException::new);
    }
    
    double getAvarage(List<Integer> list) {
        return (double)list.stream().reduce(0, Integer::sum) / (double)list.size();
    }
}

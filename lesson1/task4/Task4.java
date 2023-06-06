package javaseminar.lesson1.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task4 task4 = new Task4();
        System.out.println("Задайте уравнение вида q + w = e, где q, w, e >= 0:");
        String line = scanner.nextLine();
        task4.getResult(line);
    }

    void getResult(String line) {
        String[] members = line.split(" ");
        String q = members[0];
        String w = members[2];
        String e = members[members.length - 1];
        getSolution(q, w, e);
    }

    private void getSolution(String q, String w, String e) {
        int result = Integer.parseInt(e);
        List var = new ArrayList<Integer>();
        int indexQ = -1;
        int indexW = -1;
        int index = -1; // сколько символов в числе после первого разряда ? 
        if (q.contains("?")) {
            indexQ = q.lastIndexOf("?");
        }
        if (w.contains("?")) {
            indexW = w.lastIndexOf("?");
        }
        if (indexQ > indexW) {
            func(q, indexQ, w, e);
        } else if (indexQ < indexW) {
            func(w, indexW, q, e);
        } else if ((indexQ == indexW) & (indexQ != -1)) {
            func(q, indexQ, w, e);
        } else {
            System.out.println("Нет доступных переменных для поиска");
        }
    }

    private void func(String numberF, int z, String numberS, String r) {
        List var = new ArrayList<Integer>();
        int result = Integer.parseInt(r);
        int index = numberF.length() - z - 1;
        int number1 = 0;
        if (numberF.length() > z + 1) {
            number1 = Integer.parseInt(numberF.substring(z + 1));
        }
        int number2 = 0;
        if (index > 0) {
            number2 = Integer.parseInt(numberS.substring(numberS.length() - index));
        }
        int res = number1 + number2;
        int count = 0;
        if (String.valueOf(res).length() > String.valueOf(number1).length()) {
            count += Integer.parseInt(String.valueOf(res).split("")[0]);
        }
        int x = 0;
        if ((numberS.length() > index) & ((numberS.length() - numberS.lastIndexOf("?") - 1) != index)) {
            x = Integer.parseInt(numberS.substring(numberS.length() - index - 1));
        } else if ((numberS.length() - numberS.lastIndexOf("?") - 1) == index) {
            x = -1;
        }
        for (int i = 1; i < 10; i++) {
            if (x == -1) {
                int sum = i + i + count;
                if(String.valueOf(sum).length() > 1) {
                    if ((i + i + count) == (Integer.parseInt("1" + r.substring(((r.length() - index - 1)), (r.length() - index))))) {
                        var.add(i);
                    }
                } else {
                    if ((i + i + count) == (Integer.parseInt(r.substring(((r.length() - index - 1)), (r.length() - index))))) {
                        var.add(i);
                    }
                }
            }
            int sum = i + x + count;
            if (String.valueOf(sum).length() > 1) {
                if ((i + x + count) == (Integer.parseInt("1" + r.substring(((r.length() - index - 1)), (r.length() - index))))) {
                    var.add(i);
                }
            } else {
                if ((i + x + count) == (Integer.parseInt(r.substring(((r.length() - index - 1)), (r.length() - index))))) {
                    var.add(i);
                }
            }
        }
        if (var.size() == 0) {
            System.out.println("Нет доступных вариантов решения уровнения");
        } else {
            int n1 = 0;
            int n2 = 0;
            for (int i = 0; i < var.size(); i++) {
                if (numberF.contains("?")) {
                    n1 = Integer.parseInt(numberF.replace("?", String.valueOf(var.get(i))));
                } else {
                    n1 = Integer.parseInt(numberF);
                }
                if (numberS.contains("?")) {
                    n2 = Integer.parseInt(numberS.replace("?", String.valueOf(var.get(i))));
                } else {
                    n2 = Integer.parseInt(numberS);
                }
                if ((n1 + n2) == result) {
                    System.out.println("? = " + var.get(i));
                    System.out.println(n1 + " + " + n2 + " = " + r);
                }
            }
        }
    }
}

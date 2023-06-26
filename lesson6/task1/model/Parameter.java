package javaseminar.lesson6.task1.model;

import java.util.ArrayList;
import java.util.List;

public class Parameter {
    private List<String> listOS;
    private List<Long> listRAM;
    private List<Long> listHDD;
    private List<String> listColors;

    public Parameter() { //класс параметров ноутбуков
        addListOS();
        addListRAM();
        addListHDD();
        addListColors();
    }

    public List<String> getListColors() {
        return listColors;
    }

    public List<Long> getListHDD() {
        return listHDD;
    }

    public List<String> getListOS() {
        return listOS;
    }

    public List<Long> getListRAM() {
        return listRAM;
    }

    private void addListOS() { //создает список доступных операционных систем
        this.listOS = new ArrayList<>();
        this.listOS.add("Windows");
        this.listOS.add("Linux");
    }

    private void addListRAM() { //создает список доступных RAM
        this.listRAM = new ArrayList<>();
        this.listRAM.add(4L);
        this.listRAM.add(8L);
        this.listRAM.add(16L);
        this.listRAM.add(32L);
    }

    private void addListHDD() { //создает список доступных HDD
        this.listHDD = new ArrayList<>();
        this.listHDD.add(512L);
        this.listHDD.add(1024L);
    }

    private void addListColors() { //создает список доступных цветов
        this.listColors = new ArrayList<>();
        this.listColors.add("Чёрный");
        this.listColors.add("Белый");
        this.listColors.add("Красный");
        this.listColors.add("Синий");
    }
}

package javaseminar.lesson6.task1.model;

import java.util.Random;

public class Laptop {
    private long number;
    private String os;
    private long RAM;
    private long HDD;
    private String color;
    private Parameter parameter;
    private Random random = new Random();

    public Laptop(Parameter parameter) {
        this.number = random.nextInt(20) + random.nextInt(100);
        this.parameter = parameter;
        this.os = parameter.getListOS().get(random.nextInt(parameter.getListOS().size())); //генерирует значение операционной системы
        this.RAM = parameter.getListRAM().get(random.nextInt(parameter.getListRAM().size())); //генерирует значение RAM
        this.HDD = parameter.getListHDD().get(random.nextInt(parameter.getListHDD().size())); //генерирует значение HDD
        this.color = parameter.getListColors().get(random.nextInt(parameter.getListColors().size())); // генерирует цвет
    }

    public String getColor() {
        return color;
    }

    public long getHDD() {
        return HDD;
    }

    public String getOs() {
        return os;
    }

    public long getRAM() {
        return RAM;
    }

    @Override
    public String toString() {
        return "Ноутбук серийный номер: " + this.number + "\n"
        + "операционная система -> " + this.os + "\n" 
        + "RAM -> " + this.RAM + " Gb\n"
        + "HDD -> " + this.HDD + " GB\n"
        + "цвет -> " + this.color + "\n";
    }
}

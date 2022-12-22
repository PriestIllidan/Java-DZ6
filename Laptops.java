import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и
// выведет ноутбуки, отвечающие фильтру.
// Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

public class Laptops {
    int id;
    int RAM;
    int HDD;
    double CPU;
    String OS;
    String brand;
    String color;

    public Laptops(int id, int RAM, int HDD, double CPU, String OS, String brand, String color) {
        this.id = id;
        this.RAM = RAM;
        this.HDD = HDD;
        this.CPU = CPU;
        this.OS = OS;
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " + "RAM: " + RAM + ", " + "HDD: " + HDD +
                "CPU: " + CPU + ", " + "OS: " + OS + ", " + "brand: " + brand + ", " + "color: " + color + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        Laptops newLaptop = (Laptops) obj;
        return this.id == newLaptop.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    static String selectLaptop() {
        Map<Integer, String> mapLaptops = new HashMap<>();
        mapLaptops.put(1, "RAM = ");
        mapLaptops.put(2, "HDD = ");
        mapLaptops.put(3, "CPU = ");
        System.out.println("Manual:\n" + "1 = RAM\n" + "2 = HDD\n" + "3 = CPU\n");

        System.out.println("Enter criterion: ");
        Scanner scanner = new Scanner(System.in);
        int filter1 = scanner.nextInt();
        scanner.nextLine();
        // scanner.close();
        if (mapLaptops.containsKey(filter1)) {
            return mapLaptops.get(filter1);
            
        } else {
            return "There is no such criterion.";
        }
        

    }

    public static void main(String[] args) {
        Laptops lap1 = new Laptops(1, 4, 500, 2.5, "Windows", "Dell", "black");
        Laptops lap2 = new Laptops(2, 2, 200, 1.8, "Windows", "Apple", "gray");
        Laptops lap3 = new Laptops(3, 4, 1000, 3.2, "Windows", "Asus", "black");
        Laptops lap4 = new Laptops(4, 4, 1000, 2.7, "Windows", "Dell", "white");
        Laptops lap5 = new Laptops(5, 2, 500, 2.3, "macOS", "Apple", "white");
        Laptops lap6 = new Laptops(4, 4, 1000, 2.7, "Windows", "Dell", "white");

        HashSet<Laptops> laptops = new HashSet<>();
        laptops.add(lap1);
        laptops.add(lap2);
        laptops.add(lap3);
        laptops.add(lap4);
        laptops.add(lap5);
        laptops.add(lap6);

        System.out.println(laptops);

        String criterion = selectLaptop();
        System.out.print(criterion);

        String[] strCriterion = criterion.split(" ");
        Scanner sc = new Scanner(System.in);
        String charac = sc.nextLine();
        if (strCriterion[0].equals("RAM")) {
            int ch = Integer.parseInt(charac);
            if (ch == 2) {
                System.out.println(lap2.toString() + lap4.toString());
            } else if (ch == 4) {
                System.out.println(lap1.toString() + lap3.toString() + lap4.toString());
            } else
                System.out.println("There are no laptops");
        } else if (strCriterion[0].equals("HDD")) {
            int ch = Integer.parseInt(charac);
            if (ch <= 500) {
                System.out.println(lap1.toString() + lap2.toString() + lap5.toString());
            } else if (ch > 500 && ch <= 1000) {
                System.out.println(lap3.toString() + lap4.toString());
            } else
                System.out.println("There are no laptops");
        } else if (strCriterion[0].equals("CPU")) {
            double ch = Double.parseDouble(charac);
            if (ch >= 1.5 && ch <= 2.5) {
                System.out.println(lap1.toString() + lap2.toString() + lap5.toString());
            } else if (ch > 2.5 && ch <= 3.2) {
                System.out.println(lap3.toString() + lap4.toString());
            } else
                System.out.println("There are no laptops");
        }
        sc.close();

    }
}
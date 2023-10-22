package Solution;

import Gemstone.Diamond;
import Gemstone.Emerald;
import Gemstone.Gemstone;
import Glassstone.GlassStone;
import Glassstone.Jasper;
import Glassstone.Malachite;

import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

import static Solution.Main.*;

public class Functions {
    public static void add_stone() {
        System.out.println("Выберите категорию камня: \n 1. Драгоценный \n 2. Полудрагоценный");
        int choice = -1;
        while (choice == -1)
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после считывания числа
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите цифру.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        switch (choice)
        {
            case 1:
                AbstractFactory factory = StoneFactory.getFactory(StoneFactory.StoneFactoryType.GEMSTONE);
                use_factory(factory);
                break;
            case 2:
                factory = StoneFactory.getFactory(StoneFactory.StoneFactoryType.GLASSSTONE);
                use_factory(factory);
                break;
        }
    }

    public static void remove_stone() {
        if (stones.isEmpty()) {
            System.out.println("У вас нет камней, чтобы удалять!");
            return;
        }

        int stoneCounter = 1;
        for (Stone stone : stones) {
            System.out.println(stoneCounter + ". " + stone);
            stoneCounter++;
        }

        System.out.println("\nВведите номер камня, который нужно убрать: ");
        int stoneToRemove = 1;

        try {
            stoneToRemove = scanner.nextInt();

            if (stoneToRemove < 1 || stoneToRemove > stones.size()) {
                System.out.println("Ошибка: Неверный номер камня.");
                return;
            }
            System.out.println("Удаление камня прошло успешно!");
            stones.remove(stoneToRemove - 1);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите числовой выбор.");
            scanner.nextLine(); // Очистка буфера ввода
        }
    }

    public static void count_price() {
        if (stones.isEmpty()) {
            System.out.println("У вас нет камней, чтобы считать стоимость!");
            return;
        }
        stones.forEach(stone -> {
            System.out.println(stones.indexOf(stone) + 1 + ". " + stone);
        });
        // Вычисляем общую стоимость всех элементов
        double totalCost = stones.stream()
                .mapToDouble(stone -> stone.getPrice())
                .sum();

        System.out.println("Общая стоимость: $" + totalCost);
    }

    public static void use_factory(AbstractFactory factory) {
        System.out.println("Введите цену камня: ");
        double price = 0;
        try {
            price = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите числовое значение для цены.");
            scanner.nextLine(); // Очистка буфера ввода
            return;
        }

        System.out.println("Введите вес камня: ");
        double weight = 0;
        try {
            weight = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите числовое значение для веса.");
            scanner.nextLine(); // Очистка буфера ввода
            return;
        }

        stones.add(factory.getStone(weight, price));
        original_array_of_stones.add(factory.getStone(weight, price));
    }

    public static void sort_by_price() {
        if (stones.isEmpty()) {
            System.out.println("У вас нет камней, чтобы сортировать!");
            return;
        }
        Collections.sort(stones, Comparator.comparing(Stone::getPrice));
        System.out.println("Сортировка по цене:");
        print_stones();
    }

    public static void sort_by_weight() {
        if (stones.isEmpty()) {
            System.out.println("У вас нет камней, чтобы сортировать!");
            return;
        }
        MyThread thread1 = new MyThread();
        thread1.setName("Нить Thread");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.setName("Нить Runnable");

        thread1.start();
        try {
            thread1.join(); // Ждем, пока thread1 завершит сортировку
            System.out.println("\t" + thread1.getName() + " закончила сортировку");
            System.out.println("\n\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            thread2.join(); // Ждем, пока thread2 завершит сортировку
            System.out.println("\t" + thread2.getName() + " закончила сортировку");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Сортировка завершена.");
    }

    public static void print_stones() {
        int stoneCounter = 1;
        for (Stone stone : stones) {
            System.out.println(stoneCounter + ". " + stone);
            stoneCounter++;
        }
    }

    // Используем Stream API
    public static void filter_by_type() {
        if (stones.isEmpty()) {
            System.out.println("У вас нет камней, чтобы фильтровать!");
            return;
        }

        if (!filterByType) {
            // Сохраняем исходные данные
            filtered_by_type_stones.clear();
            filtered_by_type_stones.addAll(stones);
            //фильтруем
            System.out.println("Выберете тип камня:\n 1. Драгоценные \n 2. Стеклянные");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    stones = stones.stream()
                            .filter(stone -> stone instanceof Emerald || stone instanceof Diamond || stone instanceof Gemstone)
                            .collect(Collectors.toList());
                    filterByType = true;
                    break;
                case 2:
                    stones = stones.stream()
                            .filter(stone -> stone instanceof GlassStone || stone instanceof Jasper || stone instanceof Malachite)
                            .collect(Collectors.toList());
                    filterByType = true;
                    break;
                default:
                    System.out.println("Проверьте правильность ввода!");
            }
        } else if (filterByType){
            stones.clear();
            stones.addAll(filtered_by_type_stones);
            filterByType = false;
        }
    }

    public static void filter_by_price() {
        if (stones.isEmpty()) {
            System.out.println("У вас нет камней, чтобы фильтровать!");
            return;
        }

        if (!filterByPrice) {
            // Сохраняем исходные данные
            filtered_by_price_stones.clear();
            filtered_by_price_stones.addAll(stones);
            //фильтруем
            System.out.println("Введите минимальную цену для фильтрации: ");
            double minPrice = scanner.nextDouble();
            stones = stones.stream()
                    .filter(stone -> stone.getPrice() >= minPrice)
                    .collect(Collectors.toList());
            filterByPrice = true;
        }
        else if (filterByPrice) {
            stones.clear();
            stones.addAll(filtered_by_price_stones);
            filterByPrice = false;
        }
    }
    public static void reset_filters() {
        stones.clear();
        stones.addAll(original_array_of_stones);
    }
}

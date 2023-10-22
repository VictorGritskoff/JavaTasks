package Solution;

import UsersSettings.Authentication;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static Solution.Functions.*;

public class Main {

    static List<Stone> stones = new CopyOnWriteArrayList<>();
    static List<Stone> filtered_by_price_stones = new CopyOnWriteArrayList<>();
    static List<Stone> filtered_by_type_stones = new CopyOnWriteArrayList<>();
    static List<Stone> original_array_of_stones = new CopyOnWriteArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean filterByType = false;
    static boolean filterByPrice = false;


    public static void main(String[] args) {

        start();

        int choice = 0;
        System.out.println("Добро пожаловать!");
        do {
            System.out.print("\n\n 1. Добавить камень,\n 2. Удалить камень, \n 3. Посчитать стоимость ожерелья, \n 4. Сортировать по цене, \n 5. Сортировать по весу c помощью нитей,\n" +
                    " 6. Фильтровать по типу,\n 7. Фильтровать по цене, \n 8. Сбросить фильтры, \n 9. Выйти \n Выберите действие: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после считывания числа
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите цифру.");
                scanner.nextLine(); // Очистка буфера ввода
                continue;
            }

            switch (choice) {
                case 1:
                    add_stone();
                    break;
                case 2:
                    remove_stone();
                    break;
                case 3:
                    count_price();
                    break;
                case 4:
                    sort_by_price();
                    break;
                case 5:
                    sort_by_weight();
                    break;
                case 6:
                    filter_by_type();
                    break;
                case 7:
                    filter_by_price();
                    break;
                case 8:
                    reset_filters();
                    break;
                case 9:
                    start();
                    break;
                default:
                    System.out.println("Ошибка: выбрано неверное действие");
            }
        } while (true);
    }

    public static void start() {
        int input = 0;
            System.out.println("1. Войти\n2. Зарегестрироваться\n3. Выйти\n\n");
            try {
                input = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после считывания числа
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите цифру.");
                scanner.nextLine(); // Очистка буфера ввода
            }
            switch (input){
                case 1:
                    Authentication.login();
                    break;
                case 2:
                    System.out.print("\tВведите ваше новый username: ");
                    String name = scanner.nextLine();
                    System.out.print("\tВведите ваше новый password: ");
                    String password = scanner.nextLine();
                    Authentication.registerUser(name, password);
                    break;
                case 3:
                    System.out.println("Завершение работы...");
                    System.exit(1);
                    break;
            }
    }
}

package UsersSettings;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Authentication {
    private static HashMap<String, String> users = new HashMap<>(); // Хранилище для имен и паролей пользователей

    static {
        users.put("admin", "admin");
        users.put("user", "user");
    }

    public static void registerUser(String username, String password) {
        users.put(username, password);
    }

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;

        do {
            System.out.print("Введите имя пользователя: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            if (users.containsKey(username) && users.get(username).equals(password)) {
                loggedIn = true; // Вход успешен
                adminCheck(scanner, username);
            } else {
                System.out.println("Ошибка: Неправильное имя пользователя или пароль. Попробуйте снова.");
            }
        } while (!loggedIn);

        return true;
    }

    public static void showAllUsers() {
        for (Map.Entry<String, String> entry : users.entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();
            System.out.println("Имя пользователя: " + username + ", Пароль: " + password);
        }
    }

    public static void deleteUser(Scanner scanner) {
        showAllUsers();
        System.out.print("Введите username:");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            users.remove(username);
        }
    }

    public static void adminCheck(Scanner scanner, String username) {
        if (username.equals("admin")) {
            int input = 0;
            System.out.println("Добро пожаловать, admin. ");
            do {
                System.out.println("Выберите действие: " +
                        "\n 1. Посмотреть всех пользователей\n 2. Удалить пользователя\n Нажмите 3 для входа в систему");
                try {
                    input = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера после считывания числа
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите цифру.");
                    scanner.nextLine(); // Очистка буфера ввода
                }
                switch (input){
                    case 1:
                        showAllUsers();
                        break;
                    case 2:
                        deleteUser(scanner);
                        break;
                    case 3:
                        break;
                }
            } while(input != 3);
        }
    }
}

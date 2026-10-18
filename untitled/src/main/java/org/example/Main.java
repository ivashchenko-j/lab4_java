package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Головний клас програми з консольним меню для управління колекцією об'єктів Clothes.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Clothes> clothesList = new ArrayList<>();
        int choice = 0;

        do {
            System.out.println("\n--- CONSOLE MENU ---");
            System.out.println("1. Створити новий об’єкт");
            System.out.println("2. Вивести інформацію про всі об’єкти");
            System.out.println("3. Завершити роботу");
            System.out.print("Оберіть пункт меню (1-3): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Помилка: введіть ціле число від 1 до 3.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createClothesItem(scanner, clothesList);
                    break;
                case 2:
                    printAllClothes(clothesList);
                    break;
                case 3:
                    System.out.println("Завершення роботи програми...");
                    break;
                default:
                    System.out.println("Помилка: такого пункту меню не існує. Спробуйте ще раз.");
            }
        } while (choice != 3);

        scanner.close();
    }

    /**
     * Метод для створення та додавання нового об'єкта Clothes з обробкою винятків.
     */
    private static void createClothesItem(Scanner scanner, List<Clothes> clothesList) {
        System.out.println("\n--- Створення нового одягу ---");

        try {
            System.out.print("Введіть назву (Name): ");
            String name = scanner.nextLine();

            System.out.print("Введіть розмір (Size): ");
            String size = scanner.nextLine();

            System.out.print("Введіть колір (Color): ");
            String color = scanner.nextLine();

            System.out.print("Введіть ціну (Price): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Помилка: ціна повинна бути числом.");
                scanner.next();
                return;
            }
            double price = scanner.nextDouble();
            scanner.nextLine();


            Clothes item = new Clothes(name, size, color, price);
            clothesList.add(item);
            System.out.println("Успішно створено та додано: " + item);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка валідації даних: " + e.getMessage());
        }
    }

    /**
     * Виводить список усіх створених об'єктів.
     */
    private static void printAllClothes(List<Clothes> clothesList) {
        System.out.println("\n--- Список всього одягу ---");
        if (clothesList.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        for (int i = 0; i < clothesList.size(); i++) {
            System.out.println((i + 1) + ". " + clothesList.get(i).toString());
        }
    }
}
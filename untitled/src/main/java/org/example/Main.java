package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of clothes: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Error: enter a whole number.");
            scanner.close();
            return;
        }

        int count = scanner.nextInt();
        scanner.nextLine();

        if (count <= 0) {
            System.out.println("Error: number must be greater than zero.");
            scanner.close();
            return;
        }

        Clothes[] clothes = new Clothes[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nClothes #" + (i + 1));

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Color: ");
            String color = scanner.nextLine();

            System.out.print("Price: ");

            if (!scanner.hasNextDouble()) {
                System.out.println("Error: enter a valid price.");
                scanner.close();
                return;
            }

            double price = scanner.nextDouble();
            scanner.nextLine();

            if (price < 0) {
                System.out.println("Error: price cannot be negative.");
                scanner.close();
                return;
            }

            clothes[i] = new Clothes(name, size, color, price);
        }

        System.out.println("\n--- All clothes ---");

        for (Clothes item : clothes) {
            System.out.println(item.toString());
        }

        scanner.close();
    }
}

package org.example;

import java.util.Objects;

/**
 * Клас, що описує одяг з атрибутами: назва, розмір, колір та ціна.
 * Містить перевірки коректності вхідних даних у конструкторі та сетерах.
 */
public class Clothes {
    private String name;
    private String size;
    private String color;
    private double price;

    /**
     * Конструктор для створення об'єкта Clothes.
     *
     * @ назва одягу (не може бути null або пустою)
     * @param size  розмір (не може бути null або пустим)
     * @param color колір (не може бути null або пустим)
     * @param price ціна (не може бути від'ємною)
     * @throws IllegalArgumentException якщо передано некоректні дані
     */
    public Clothes(String name, String size, String color, double price) {
        setName(name);
        setSize(size);
        setColor(color);
        setPrice(price);
    }

    /**
     * Повертає назву одягу.
     * @return назва
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву одягу з перевіркою.
     * @param name назва
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name.trim();
    }

    /**
     * Повертає розмір одягу.
     * @return розмір
     */
    public String getSize() {
        return size;
    }

    /**
     * Встановлює розмір одягу з перевіркою.
     * @param size розмір
     */
    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Size cannot be null or empty.");
        }
        this.size = size.trim();
    }

    /**
     * Повертає колір одягу.
     * @return колір
     */
    public String getColor() {
        return color;
    }

    /**
     * Встановлює колір одягу з перевіркою.
     * @param color колір
     */
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty.");
        }
        this.color = color.trim();
    }

    /**
     * Повертає ціну одягу.
     * @return ціна
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну одягу з перевіркою.
     * @param price ціна
     */
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Clothes clothes)) return false;
        return Double.compare(price, clothes.price) == 0
                && Objects.equals(name, clothes.name)
                && Objects.equals(size, clothes.size)
                && Objects.equals(color, clothes.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price);
    }
}

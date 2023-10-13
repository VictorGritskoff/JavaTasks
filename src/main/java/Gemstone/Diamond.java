package Gemstone;

import Solution.Stone;

public class Diamond implements Stone {
    public static final double MAX_PRICE = 500;
    private double price;
    private double weight;

    public Diamond(double weight, double price) {
        this.price = price;
        this.weight = weight;
    }
    public Diamond() {

    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\n Камень: Diamond, Цена: $" + price + " Вес: " + weight + " гр.";
    }
}

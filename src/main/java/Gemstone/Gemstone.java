package Gemstone;

import Solution.Stone;

public class Gemstone implements Stone {
    public static final double MAX_PRICE = 1000;
    private double price;
    private double weight;

    public Gemstone(double weight, double price) {
        this.price = price;
        this.weight = weight;
    }
    public Gemstone() {

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
        return "\n Камень: Gemstone, Цена: $" + price + " Вес: " + weight+ " гр.";
    }
}

package Gemstone;

import Solution.Stone;

public class Emerald implements Stone {
    public static final double MAX_PRICE = 200;
    private double price;
    private double weight;

    public Emerald(double weight, double price) {
        this.price = price;
        this.weight = weight;
    }
    public Emerald() {

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
        return "\n Камень: Emerald, Цена: $" + price + " Вес: " + weight + " гр.";
    }
}

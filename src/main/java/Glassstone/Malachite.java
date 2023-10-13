package Glassstone;

import Solution.Stone;

public class Malachite implements Stone {
    public static final double MAX_PRICE = 50;
    private double price;
    private double weight;

    public Malachite(double weight, double price) {
        this.price = price;
        this.weight = weight;
    }
    public Malachite() {

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
        return "\n Камень: Malachite, Цена: $" + price + " Вес: " + weight + " гр.";
    }
}

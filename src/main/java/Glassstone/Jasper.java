package Glassstone;

import Solution.Stone;

public class Jasper implements Stone {
    public static final double MAX_PRICE = 80;
    private double price;
    private double weight;

    public Jasper(double weight, double price) {
        this.price = price;
        this.weight = weight;
    }
    public Jasper() {

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
        return "\n Камень: Jasper, Цена: $" + price + " Вес: " + weight + " гр.";
    }
}

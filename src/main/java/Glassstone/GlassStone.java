package Glassstone;

import Solution.Stone;

public class GlassStone implements Stone {
    private double price;
    private double weight;

    public GlassStone(double weight, double price) {
        this.price = price;
        this.weight = weight;
    }
    public GlassStone() {

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
        return "\n Камень: GlassStone, Цена: $" + price + " Вес: " + weight + " гр.";
    }
}

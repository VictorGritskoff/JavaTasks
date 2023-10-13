package Gemstone;

import Solution.AbstractFactory;
import Solution.Stone;

public class GemstoneFactory implements AbstractFactory {
    public Stone getStone (double weight, double price) {
        Stone stone = null;

        if (price <= Emerald.MAX_PRICE) {
            stone = new Emerald(weight, price);
        }

        else if (price <= Diamond.MAX_PRICE){
            stone = new Diamond(weight, price);
        }

        else {
            stone = new Gemstone(weight, price);
        }
        return stone;
    }
}

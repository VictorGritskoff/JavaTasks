package Glassstone;

import Gemstone.Gemstone;
import Solution.AbstractFactory;
import Solution.Stone;

public class GlassStoneFactory implements AbstractFactory {
    public Stone getStone (double weight, double price) {
        Stone stone = null;

        if (price <= Malachite.MAX_PRICE) {
            stone = new Malachite(weight, price);
        }

        else if (price <= Jasper.MAX_PRICE){
            stone = new Jasper(weight, price);
        }
        else {
            stone = new GlassStone(weight, price);
        }
        return stone;
    }
}

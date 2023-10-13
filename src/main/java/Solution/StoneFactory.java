package Solution;

import Gemstone.GemstoneFactory;
import Glassstone.GlassStoneFactory;

public class StoneFactory {
    public enum StoneFactoryType {
        GEMSTONE,
        GLASSSTONE
    }
    public static AbstractFactory getFactory(StoneFactoryType type) {
        if (type == StoneFactoryType.GEMSTONE) {
            return new GemstoneFactory();
        } else {
            return new GlassStoneFactory();
        }
    }
}

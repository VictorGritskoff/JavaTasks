package Solution;

import java.util.Collections;
import java.util.Comparator;

import static Solution.Functions.print_stones;
import static Solution.Main.stones;

public class MyRunnable  implements Runnable{
    @Override
    public void run() {
        Collections.sort(stones, Comparator.comparing(Stone::getWeight)); // по возрастанию
        System.out.println("Сортировка по весу:");
        print_stones();
    }
}

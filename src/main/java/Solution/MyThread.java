package Solution;

import java.util.Collections;
import java.util.Comparator;

import static Solution.Functions.print_stones;
import static Solution.Main.stones;

public class MyThread extends Thread{
    @Override
    public void run() {
        Comparator<Stone> comparator = Comparator.comparing(Stone::getWeight);
        Collections.sort(stones, comparator.reversed()); // по убыванию
        System.out.println("Сортировка по весу:");
        print_stones();
    }
}

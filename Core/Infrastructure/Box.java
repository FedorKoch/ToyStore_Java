package Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Core.Models.Toy;

public class Box {

    private List<Toy> toys = new ArrayList<>();
    private Random random = new Random();

    public void putToy(Toy toy) {
        toys.add(toy);
    }

    public Toy getPrizeToy() {
        if (!toys.isEmpty()) {
            int totalProbability = toys.stream().mapToInt(toy -> toy.getProbability()).sum();
            int value = random.nextInt(totalProbability);
            for (Toy toy : toys) {
                value -= toy.getProbability();
                if (value <= 0) {
                    toys.remove(toy);
                    return toy;
                }
            }
        }
        return null;
    }

    public Toy getToyById(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (Toy toy : toys) {
            result += toy+"\n";
        }
        return result;

    }
}
package Core.Infrastructure;

import java.util.LinkedList;
import java.util.Queue;

import Core.Models.Toy;

public class Prize {

    Queue<Toy> toyQueue = new LinkedList<>();

    public void addToQueue(Toy prizeToy) {
        toyQueue.add(prizeToy);
    }

    public Toy getToyFromQueue() {
        if (toyQueue.isEmpty()) {
            return null;
        }
        return toyQueue.poll();
    }

    @Override
    public String toString() {
        String result = "";
        for (Toy toy : toyQueue) {
            result += toy+"\n";
        }
        return result;
    }

}
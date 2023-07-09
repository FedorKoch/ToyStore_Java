package Core.Models;

import java.io.FileWriter;
import java.io.IOException;

public class Toy implements Comparable<Toy> {

    private final String name;
    private int probability;
    private int id;
    private static int nextId = 1;

    public Toy(String name, int probability) {
        this.name = name;
        this.probability = probability;
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    public int getProbability() {
        return probability;
    }

    public int getId() {
        return id;
    }

    public void setProbability(int probability) {
        this.probability = probability;

    }

    public String exportToFile() {
        try {
            FileWriter writer = new FileWriter("PrizeToys.txt", true);
            writer.write(this.toString());
            writer.write(System.lineSeparator());
            writer.close();
            return "Игрушка успешно экспортирована в файл.";
        } catch(IOException e) {
            return "Произошла ошибка при экспортировании игрушки в файл.";
            // e.printStackTrace();
        }
    }

    

    @Override
    public String toString() {
        return "игрушка [Название=" + name + ", Вероятность 0-100=" + probability + ", id=" + id + "]";
    }

    @Override
    public int compareTo(Toy other) {

        return Double.compare(this.probability, other.getProbability());

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + probability;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Toy other = (Toy) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (probability != other.probability)
            return false;
        if (id != other.id)
            return false;
        return true;
        
    }

    
}
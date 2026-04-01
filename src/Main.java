import java.util.*;

class Bogie {
    private String id;
    private String type;
    private int capacity;

    public Bogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " (" + id + ") - Seats: " + capacity;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        // 1. User creates a list of bogies
        List<Bogie> consist = Arrays.asList(
                new Bogie("S1", "Sleeper", 72),
                new Bogie("S2", "Sleeper", 72),
                new Bogie("A1", "AC Chair", 56),
                new Bogie("F1", "First Class", 24)
        );

        System.out.println("--- Current Train Consist ---");
        consist.forEach(System.out::println);

        // 2. Convert to stream, 3. map() to capacity, 4. reduce() to sum
        int totalSeats = consist.stream()
                .map(Bogie::getCapacity)        // Transformation: Bogie -> Integer
                .reduce(0, Integer::sum);       // Aggregation: (runningTotal, nextValue) -> sum

        // 5. Total seating capacity is displayed
        System.out.println("\n------------------------------");
        System.out.println("Total Seating Capacity: " + totalSeats);
        System.out.println("------------------------------");
    }
}
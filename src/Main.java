import java.util.*;
import java.util.stream.Collectors;

// Base class for Bogies
class Bogie {
    private String id;
    private String type; // e.g., "Sleeper", "AC Chair", "Rectangular"

    public Bogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Bogie{ID='" + id + "'}";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        // 1. User creates a list of bogies
        List<Bogie> consist = Arrays.asList(
                new Bogie("S1", "Sleeper"),
                new Bogie("S2", "Sleeper"),
                new Bogie("A1", "AC Chair"),
                new Bogie("G1", "Rectangular"),
                new Bogie("G2", "Cylindrical"),
                new Bogie("A2", "AC Chair")
        );

        System.out.println("--- Original Flat Consist List ---");
        consist.forEach(System.out::println);

        // 2. System converts list to stream & 3. groupingBy() is applied
        Map<String, List<Bogie>> groupedBogies = consist.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // 5. Grouped result is displayed
        System.out.println("\n--- Grouped Bogie Report (UC9) ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: [" + type + "] -> " + list);
        });

        System.out.println("\nProgram continues...");
    }
}
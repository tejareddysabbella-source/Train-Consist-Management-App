import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    int capacity;
    public Bogie(int capacity) { this.capacity = capacity; }
    public int getCapacity() { return capacity; }
}

public class PerformanceBenchmarkingApp {
    public static void main(String[] args) {
        // 1. Prepare a large collection of bogies for testing
        List<Bogie> trainConsist = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            trainConsist.add(new Bogie(new Random().nextInt(100)));
        }

        // --- Loop-Based Filtering ---
        long startLoop = System.nanoTime(); // Record start time
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : trainConsist) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }
        long endLoop = System.nanoTime(); // Record end time
        long loopDuration = endLoop - startLoop;

        // --- Stream-Based Filtering ---
        long startStream = System.nanoTime(); // Record start time
        List<Bogie> streamResult = trainConsist.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime(); // Record end time
        long streamDuration = endStream - startStream;

        // Display results
        System.out.println("--- Performance Results (nanoseconds) ---");
        System.out.println("Loop Duration  : " + loopDuration + " ns");
        System.out.println("Stream Duration: " + streamDuration + " ns");
        System.out.println("Results Match  : " + (loopResult.size() == streamResult.size()));
    }
}
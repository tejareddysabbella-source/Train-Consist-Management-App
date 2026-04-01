import java.util.*;

// 1. Create a custom exception class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String id;
    private int capacity;

    // 2. Validate capacity inside the constructor
    // 3. Declare the constructor with 'throws'
    public PassengerBogie(String id, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            // 4. Throw the exception when capacity is invalid
            throw new InvalidCapacityException("Capacity must be greater than zero. Provided: " + capacity);
        }
        this.id = id;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{ID='" + id + "', Capacity=" + capacity + "}";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("--- UC14: Custom Exception Validation ---");

        try {
            // Attempting to create a valid bogie
            PassengerBogie s1 = new PassengerBogie("S1", 72);
            System.out.println("✅ Successfully created: " + s1);

            // Attempting to create an invalid bogie (Zero Capacity)
            System.out.println("\nAttempting to create bogie with 0 capacity...");
            PassengerBogie invalid1 = new PassengerBogie("S2", 0);

        } catch (InvalidCapacityException e) {
            // System handles the error and prevents the object from being added
            System.err.println("❌ Error: " + e.getMessage());
        }

        try {
            // Attempting to create an invalid bogie (Negative Capacity)
            System.out.println("\nAttempting to create bogie with -10 capacity...");
            PassengerBogie invalid2 = new PassengerBogie("S3", -10);

        } catch (InvalidCapacityException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}
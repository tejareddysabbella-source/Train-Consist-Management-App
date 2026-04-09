<<<<<<< HEAD
// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
=======
import java.util.*;

// 1. Create a custom exception class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
>>>>>>> f548096978e7ae43406b1b33077b0411f2d7fa66
        super(message);
    }
}

<<<<<<< HEAD
// Abstract Goods Bogie
abstract class GoodsBogie {
    protected String shape;
    protected String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            // Validation logic
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe cargo! Petroleum cannot be assigned to Rectangular bogie."
                );
            }

            // If safe
            this.cargo = cargoType;
            System.out.println("✅ Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            // Handle exception gracefully
            System.out.println("❌ Error: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("ℹ️ Cargo assignment attempt completed for " + shape + " bogie.\n");
        }
    }

    public String getCargo() {
        return cargo;
    }
}

// Rectangular Bogie
class RectangularBogie extends GoodsBogie {
    public RectangularBogie() {
        super("Rectangular");
    }
}

// Cylindrical Bogie
class CylindricalBogie extends GoodsBogie {
    public CylindricalBogie() {
        super("Cylindrical");
    }
}

// Main Application
public class TrainConsistApp {
    public static void main(String[] args) {

        GoodsBogie rectangular = new RectangularBogie();
        GoodsBogie cylindrical = new CylindricalBogie();

        // Test Case 1: Safe Assignment
        System.out.println("Test 1: Safe Assignment");
        cylindrical.assignCargo("Petroleum");

        // Test Case 2: Unsafe Assignment
        System.out.println("Test 2: Unsafe Assignment");
        rectangular.assignCargo("Petroleum");

        // Test Case 3: Continue Execution
        System.out.println("Test 3: Continue After Exception");
        rectangular.assignCargo("Coal");
        cylindrical.assignCargo("Water");

        // Verify cargo not assigned after failure
        System.out.println("\nFinal Cargo Status:");
        System.out.println("Rectangular Bogie Cargo: " + rectangular.getCargo());
        System.out.println("Cylindrical Bogie Cargo: " + cylindrical.getCargo());
=======
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
>>>>>>> f548096978e7ae43406b1b33077b0411f2d7fa66
    }
}
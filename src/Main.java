// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

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
    }
}
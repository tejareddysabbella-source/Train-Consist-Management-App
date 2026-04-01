import java.util.*;

class GoodsBogie {
    private String id;
    private String type; // e.g., "Cylindrical", "Rectangular"
    private String cargo; // e.g., "Petroleum", "Coal"

    public GoodsBogie(String id, String type, String cargo) {
        this.id = id;
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return type + " [" + id + "] carrying " + cargo;
    }
}

public class TrainSafetyApp {
    public static void main(String[] args) {
        // 1. User prepares a list of goods bogies
        List<GoodsBogie> goodsConsist = Arrays.asList(
                new GoodsBogie("G1", "Rectangular", "Coal"),
                new GoodsBogie("G2", "Cylindrical", "Petroleum"),
                new GoodsBogie("G3", "Cylindrical", "Petroleum"),
                new GoodsBogie("G4", "Rectangular", "Iron Ore")
        );

        System.out.println("--- Checking Train Safety Compliance ---");
        goodsConsist.forEach(System.out::println);

        // 2. Stream conversion & 3. allMatch() validation
        // Rule: If Type is Cylindrical, Cargo MUST be Petroleum.
        boolean isSafe = goodsConsist.stream().allMatch(bogie -> {
            if (bogie.getType().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies pass this specific rule
        });

        // 5. Result is displayed
        if (isSafe) {
            System.out.println("\n✅ SAFETY CHECK PASSED: Train is cleared for departure.");
        } else {
            System.out.println("\n❌ SAFETY CHECK FAILED: Hazardous cargo detected in incorrect bogie type!");
        }
    }
}
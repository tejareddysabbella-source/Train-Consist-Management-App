public class TrainConsistManagementApp {

    // Linear Search Method
    public static boolean linearSearch(String[] bogieIds, String key) {

        // Traverse array
        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // Match found
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        System.out.println("Searching for Bogie ID: " + searchKey);

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("✅ Bogie Found!");
        } else {
            System.out.println("❌ Bogie Not Found!");
        }

        // Additional Test Cases

        System.out.println("\nTest Case: Not Found");
        System.out.println(linearSearch(bogieIds, "BG999"));

        System.out.println("\nTest Case: First Element");
        System.out.println(linearSearch(bogieIds, "BG101"));

        System.out.println("\nTest Case: Last Element");
        System.out.println(linearSearch(bogieIds, "BG550"));

        System.out.println("\nTest Case: Single Element");
        String[] single = {"BG101"};
        System.out.println(linearSearch(single, "BG101"));
    }
}
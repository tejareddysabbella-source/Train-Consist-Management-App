import java.util.Arrays;

public class TrainConsistManagementApp {

    // Binary Search with Exception Handling
    public static boolean searchBogie(String[] bogieIds, String key) {
        // Defensive check
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Cannot search: No bogies have been added yet.");
        }

        // Binary search requires sorted array
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true; // Found
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        // Example with bogies
        String[] bogies = {"BG101", "BG205", "BG309"};

        try {
            System.out.println("Searching BG205: " + searchBogie(bogies, "BG205"));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Example with empty bogies
        String[] emptyBogies = {};
        try {
            System.out.println("Searching BG101: " + searchBogie(emptyBogies, "BG101"));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
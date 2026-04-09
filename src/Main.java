import java.util.Arrays;

public class TrainConsistManagementApp {

    // Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {
        if (bogieIds == null || bogieIds.length == 0) return false;

        // Ensure array is sorted
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true; // Found
            } else if (cmp < 0) {
                high = mid - 1; // Search left
            } else {
                low = mid + 1;  // Search right
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        // Sorted example
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";
        System.out.println("Searching for Bogie ID: " + searchKey);
        System.out.println(binarySearch(bogieIds, searchKey) ? "✅ Bogie Found!" : "❌ Bogie Not Found!");

        // Test Cases
        System.out.println("\nTest Case: Not Found");
        System.out.println(binarySearch(bogieIds, "BG999"));

        System.out.println("\nTest Case: First Element");
        System.out.println(binarySearch(bogieIds, "BG101"));

        System.out.println("\nTest Case: Last Element");
        System.out.println(binarySearch(bogieIds, "BG550"));

        System.out.println("\nTest Case: Single Element");
        String[] single = {"BG101"};
        System.out.println(binarySearch(single, "BG101"));

        System.out.println("\nTest Case: Empty Array");
        String[] empty = {};
        System.out.println(binarySearch(empty, "BG101"));

        System.out.println("\nTest Case: Unsorted Input");
        String[] unsorted = {"BG309","BG101","BG550","BG205","BG412"};
        System.out.println(binarySearch(unsorted, "BG205"));
    }
}
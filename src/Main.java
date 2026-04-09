import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Example bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        // Sorting using built-in method
        Arrays.sort(bogieNames);

        System.out.println("After Sorting (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        // Additional Test Cases

        System.out.println("\nTest Case: Unsorted Input");
        String[] unsorted = {"Luxury", "General", "Sleeper", "AC Chair"};
        Arrays.sort(unsorted);
        System.out.println(Arrays.toString(unsorted));

        System.out.println("\nTest Case: Already Sorted");
        String[] sorted = {"AC Chair", "First Class", "General"};
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));

        System.out.println("\nTest Case: Duplicates");
        String[] duplicates = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(duplicates);
        System.out.println(Arrays.toString(duplicates));

        System.out.println("\nTest Case: Single Element");
        String[] single = {"Sleeper"};
        Arrays.sort(single);
        System.out.println(Arrays.toString(single));
    }
}
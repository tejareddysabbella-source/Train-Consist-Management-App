public class TrainConsistManagementApp {

    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {

                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }


    public static void display(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        display(capacities);

        bubbleSort(capacities);

        System.out.println("After Sorting (Ascending):");
        display(capacities);

        System.out.println("\nTest Case: Already Sorted");
        int[] sortedArr = {24, 56, 60, 70, 72};
        bubbleSort(sortedArr);
        display(sortedArr);

        System.out.println("\nTest Case: Duplicates");
        int[] duplicateArr = {72, 56, 56, 24};
        bubbleSort(duplicateArr);
        display(duplicateArr);

        System.out.println("\nTest Case: Single Element");
        int[] singleArr = {50};
        bubbleSort(singleArr);
        display(singleArr);

        System.out.println("\nTest Case: All Equal");
        int[] equalArr = {40, 40, 40};
        bubbleSort(equalArr);
        display(equalArr);
    }
}
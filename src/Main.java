import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class TrainValidationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Define Regex Patterns
        // TRN- followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // PET- followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // 2. Compile Patterns
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);

        System.out.println("--- Train Data Validation System ---");

        // Validate Train ID
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String inputTrainId = scanner.nextLine();
        Matcher trainMatcher = trainIdPattern.matcher(inputTrainId);

        if (trainMatcher.matches()) {
            System.out.println("✅ Valid Train ID: " + inputTrainId);
        } else {
            System.out.println("❌ Invalid Train ID format! Expected TRN-XXXX (4 digits).");
        }

        // Validate Cargo Code
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String inputCargoCode = scanner.nextLine();
        Matcher cargoMatcher = cargoCodePattern.matcher(inputCargoCode);

        if (cargoMatcher.matches()) {
            System.out.println("✅ Valid Cargo Code: " + inputCargoCode);
        } else {
            System.out.println("❌ Invalid Cargo Code format! Expected PET-XX (2 uppercase letters).");
        }
    }
}
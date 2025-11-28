import java.util.Scanner;

public class InputManager {

    static HospitalList hospitalList = new HospitalList();
    static Scanner scanner = new Scanner(System.in); // Reused scanner

    public static void hospitalInput() {
        while (true) {

            // Hospital Name
            String nameHold = "";
            while (true) {
                System.out.print("Enter hospital name: ");
                nameHold = scanner.nextLine().trim();
                if (!nameHold.isEmpty()) break;
                System.out.println("Invalid name. Try again.");
            }

            // Hospital Location
            String locationHold = "";
            while (true) {
                System.out.print("Enter hospital location: ");
                locationHold = scanner.nextLine().trim();
                if (!locationHold.isEmpty()) break;
                System.out.println("Invalid location. Try again.");
            }

            // Hospital Contact (validate 10 digits)
            String contactHold = "";
            while (true) {
                System.out.print("Enter hospital contact (10 digits): ");
                contactHold = scanner.nextLine().trim();
                if (contactHold.matches("\\d{10}")) break;
                System.out.println("Invalid contact. Must be exactly 10 digits.");
            }

            // Input Disease Records
            System.out.println("Entering disease records for " + nameHold);
            DiseaseList hospitalDiseases = diseaseInput();

            // Add to HospitalList
            hospitalList.addNode(new HospitalData(nameHold, locationHold, contactHold, hospitalDiseases));

            // Ask if user wants to enter another hospital
            System.out.print("Do you want to enter another hospital record? (Y/N): ");
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("exit")) {
                break;
            }
        }
    } // end of hospitalInput


    public static DiseaseList diseaseInput() {
        DiseaseList list = new DiseaseList();


        while (true) {
            System.out.println("\n------- Entering New Disease Record -------");

            // Disease Name
            String diseaseNameHold = "";
            while (true) {
                System.out.print("Enter Disease Name: ");
                diseaseNameHold = scanner.nextLine().trim();
                if (!diseaseNameHold.isEmpty()) break;
                System.out.println("Invalid input. Try again.");
            }

            // Region
            String regionHold = "";
            while (true) {
                System.out.print("Enter Region: ");
                regionHold = scanner.nextLine().trim();
                if (!regionHold.isEmpty()) break;
                System.out.println("Invalid input. Try again.");
            }

            // Case Count

            // Cases per Week
            int[] casesPerWeekHold = new int[4];
            for (int i = 0; i < 4; ) {
                System.out.print("Enter Case Count for Week " + (i + 1) + ": ");
                String input = scanner.nextLine().trim();
                try {
                    int weekCount = Integer.parseInt(input);
                    if (weekCount >= 0) {
                        casesPerWeekHold[i] = weekCount;
                        i++;
                    } else {
                        System.out.println("Week count must be non-negative.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // Add Disease Node
            list.addNode(new DiseaseData(regionHold, diseaseNameHold, casesPerWeekHold));

            // Ask if user wants to add another disease
            System.out.print("Do you want to enter another disease record? (Y/N): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("exit")) {
                break;
            }
        }

        return list;
    } // end of diseaseInput

    public static void removeHospital() {
        if (hospitalList.isEmpty()) {
            System.out.println("No hospitals to remove. The list is empty.");
            return;
        }

        // Display all hospitals
        System.out.println("\nCurrent Hospitals:");
        System.out.println("------------------------------------------------------------------------------------");
        hospitalList.displayHospitalNames();
        System.out.println();

        // Get hospital name to remove
        String nameToRemove = "";
        while (nameToRemove.isEmpty()) {
            System.out.print("Enter the name of the hospital to remove: ");
            nameToRemove = scanner.nextLine().trim();
            if (nameToRemove.isEmpty()) {
                System.out.println("Hospital name cannot be empty. Please try again.");
            }
        }

        // Attempt to remove
        boolean removed = hospitalList.removeHospital(nameToRemove);

        if (removed) {
            System.out.println("\nHospital '" + nameToRemove + "' has been successfully removed.\n");
        } else {
            System.out.println("\nHospital '" + nameToRemove + "' was not found in the list.\n");
        }
        hospitalList.displayHospitalNames();
        System.out.println();

    }// end of removeHospital

} // end of class
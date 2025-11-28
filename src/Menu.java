import java.util.Scanner;

public class Menu {
    //Menu Class
    //Methods
    static Scanner scanner = new Scanner(System.in);
    public static int menu() {
        while (true) {


            System.out.println("------------------HealthSense healthcare Management System Menu---------------------");
            System.out.println();
            System.out.println("1. Add Hospital");
            System.out.println("2. Remove Hospital");
            System.out.println("3. List Hospitals");
            System.out.println("4. Hospital Insights");
            System.out.println("5. Search");
            System.out.println("6. Outbreak Reports");
            System.out.println("7. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input > 0 && input < 8) {
                    return input;
                } else {
                    System.out.println("Invalid input: out of range");
                }
            } else {
                System.out.println("Invalid input: not an integer");
                scanner.next();
            }

        }// end of while loop

    }// end of method
    //Analysis menu number of diseases, name, sort by severity

    public static int analysisMenu() {
        while (true) {
            System.out.println("\n------------------ HealthSense Healthcare Management System ------------------");
            System.out.println("01) View Disease Summary");
            System.out.println("02) Sort by Severity");
            System.out.println("03) Weekly Trends");
            System.out.println("04) Back");

            System.out.print("Enter your choice (1-4): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Invalid input: please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input: please enter a valid number.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    public static int RemovedMenu() {
        while (true) {
            System.out.println("\n------------------ HealthSense Healthcare Management System ------------------");
            System.out.println("01) Undo Remove");
            System.out.println("02) Remove Hospital");
            System.out.println("03) Back");

            System.out.print("Enter your choice (1-2): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Invalid input: please enter a number between 1 and 2.");
                }
            }else{
                System.out.println("Invalid input: please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public static int searchMenu() {
        while (true) {
            System.out.println("\n------------------ HealthSense Healthcare Management System ------------------");
            System.out.println("01) Search Hospital by Name");
            System.out.println("02) Search Disease by Name");
            System.out.println("03) Back");
            System.out.print("Enter your choice (1-3): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Invalid input: please enter a number between 1 and 3.");
                }
            }else{
                System.out.println("Invalid input: please enter a valid number.");
                scanner.nextLine();
            }
        }

    }

    public static int OutbreakReportsMenu() {
        while (true) {
            System.out.println("\n------------------ HealthSense Healthcare Management System ------------------");
            System.out.println("01) Next Outbreak Report");
            System.out.println("02) Add an Outbreak Report");
            System.out.println("03) Back");
            System.out.print("Enter your choice (1-3): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Invalid input: please enter a number between 1 and 2.");
                }
            }else{
                System.out.println("Invalid input: please enter a valid number.");
            }
        }
    }


}// end of class

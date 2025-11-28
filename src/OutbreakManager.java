import java.time.LocalDate;
import java.util.Scanner;

public class OutbreakManager {

    static OutbreakReportQueue reportQueue = new OutbreakReportQueue();

    public static void addOutbreakReport() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter region: ");
        String region = scanner.nextLine();

        System.out.print("Enter disease name: ");
        String diseaseName = scanner.nextLine();

        int weekNumber;
        while (true) {
            System.out.print("Enter week number (1-52): ");
            try {
                weekNumber = Integer.parseInt(scanner.nextLine());
                if (weekNumber >= 1 && weekNumber <= 52) break;
                System.out.println("Week number must be between 1 and 52.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter a number.");
            }
        }

        int cases;
        while (true) {
            System.out.print("Enter number of cases: ");
            try {
                cases = Integer.parseInt(scanner.nextLine());
                if (cases >= 0) break;
                System.out.println("Number of cases cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter a number.");
            }
        }

        LocalDate reportDate = LocalDate.now();

        OutbreakReport.Severity severity = null;
        while (severity == null) {
            System.out.print("Enter severity (MILD, MODERATE, SEVERE): ");
            try {
                severity = OutbreakReport.Severity.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid severity. Please enter MILD, MODERATE, or SEVERE.");
            }
        }

        OutbreakReport report = new OutbreakReport(region, diseaseName, weekNumber, cases, reportDate, severity);
        reportQueue.enqueue(report);
        System.out.println("Report added successfully.\n");
    }

    public static void nextOutbreakReport() {
        if (reportQueue.isEmpty()) {
            System.out.println("No outbreak reports to display. The queue is empty.\n");
            return;
        }

        OutbreakReport report = reportQueue.dequeue();
        System.out.println("Processing Outbreak Report:");
        System.out.println(report);
        System.out.println("Outbreak report has been displayed.\n");
    }
}
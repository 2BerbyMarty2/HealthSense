import java.time.LocalDate;

public class OutbreakReport {
    private String region;
    private String diseaseName;
    private int weekNumber;
    private int cases;
    private LocalDate reportDate;
    private Severity severity;

    public enum Severity {
        MILD,
        MODERATE,
        SEVERE
    }

    public OutbreakReport(String region, String diseaseName, int weekNumber, int cases, LocalDate reportDate, Severity severity) {
        this.region = region;
        this.diseaseName = diseaseName;
        this.weekNumber = weekNumber;
        this.cases = cases;
        this.reportDate = reportDate;
        this.severity = severity;
    }

    // Getters and setters

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "OutbreakReport \n" +
                "region: " + region + '\n' +
                "diseaseName: " + diseaseName + '\n' +
                "weekNumber: " + weekNumber + '\n' +
                "cases: " + cases + '\n' +
                "reportDate: " + reportDate + '\n' +
                "severity: " + severity;
    }
}
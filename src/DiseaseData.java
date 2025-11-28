import java.util.Arrays;

public class DiseaseData {

    private String diseaseName;
    private String region;
    private int[] casesPerWeek;

    public DiseaseData(String region, String diseaseName, int[] casesPerWeek) {
        this.region = region;
        this.diseaseName = diseaseName;
        this.casesPerWeek = Arrays.copyOf(casesPerWeek, casesPerWeek.length);
    }

    public int getCaseCountAll() {
        int sum = 0;
        for (int c : casesPerWeek) {
            sum += c;
        }
        return sum;
    }

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

    public int[] getCasesPerWeek() {
        return Arrays.copyOf(casesPerWeek, casesPerWeek.length);
    }

    public void setCasesPerWeek(int[] casesPerWeek) {
        this.casesPerWeek = Arrays.copyOf(casesPerWeek, casesPerWeek.length);
    }
    public void display() {
        System.out.println("========== Disease Information ==========");
        System.out.println("Name        : " + diseaseName);
        System.out.println("Region      : " + region);
        System.out.println("Total Cases : " + getCaseCountAll());

        System.out.println("Cases per week:");
        System.out.print("  Weeks      : ");
        for (int i = 0; i < casesPerWeek.length; i++) {
            System.out.printf("W%02d\t", i + 1);
        }
        System.out.println();

        System.out.print("  Case Count : ");
        for (int count : casesPerWeek) {
            System.out.printf("%d\t", count);
        }
        System.out.println("\n");
    }
}
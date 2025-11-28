import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiseaseDataTest {

    private DiseaseData disease;

    @BeforeEach
    public void setup() {
        disease = new DiseaseData("RegionA", "Flu", new int[]{10, 20, 30, 40});
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("RegionA", disease.getRegion());
        assertEquals("Flu", disease.getDiseaseName());
        assertArrayEquals(new int[]{10, 20, 30, 40}, disease.getCasesPerWeek());
    }

    @Test
    public void testGetCaseCountAll() {
        assertEquals(100, disease.getCaseCountAll());
    }

    @Test
    public void testSettersAndGetters() {
        disease.setRegion("NewRegion");
        assertEquals("NewRegion", disease.getRegion());

        disease.setDiseaseName("Cold");
        assertEquals("Cold", disease.getDiseaseName());

        int[] newCases = {5, 5, 5, 5};
        disease.setCasesPerWeek(newCases);
        assertArrayEquals(newCases, disease.getCasesPerWeek());
    }

    @Test
    public void testDefensiveCopyCasesPerWeek() {
        int[] originalArray = disease.getCasesPerWeek();
        originalArray[0] = 999; // modify external array

        // Ensure internal array not affected by external change
        int[] internalArray = disease.getCasesPerWeek();
        assertNotEquals(999, internalArray[0]);
    }

    @Test
    public void testDisplay() {
        // Just call display to check no exceptions, output goes to console
        disease.display();
    }
}

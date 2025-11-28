import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HospitalDataTest {

    private DiseaseList diseaseList;

    @BeforeEach
    public void setup() {
        diseaseList = new DiseaseList();
    }

    @Test
    public void testConstructorValidInputs() {
        HospitalData hospital = new HospitalData("City Hospital", "Colombo", "123456789", diseaseList);

        assertEquals("City Hospital", hospital.getHospitalName());
        assertEquals("Colombo", hospital.getHospitalLocation());
        assertEquals("123456789", hospital.getHospitalContact());
        assertEquals(diseaseList, hospital.getDiseaseList());
    }

    @Test
    public void testConstructorNullOrEmptyHospitalNameThrows() {
        assertThrows(IllegalArgumentException.class, () -> new HospitalData(null, "Loc", "Cont", diseaseList));
        assertThrows(IllegalArgumentException.class, () -> new HospitalData("   ", "Loc", "Cont", diseaseList));
    }

    @Test
    public void testConstructorNullLocationAndContactSetsDefaults() {
        HospitalData hospital = new HospitalData("Hospital A", null, null, null);

        assertEquals("Hospital A", hospital.getHospitalName());
        assertEquals("Unknown", hospital.getHospitalLocation());
        assertEquals("N/A", hospital.getHospitalContact());
        assertNotNull(hospital.getDiseaseList());
        assertEquals(0, hospital.getDiseaseList().size());
    }

    @Test
    public void testSettersValidAndInvalid() {
        HospitalData hospital = new HospitalData("Name", "Loc", "Cont", diseaseList);

        hospital.setHospitalName("New Name");
        assertEquals("New Name", hospital.getHospitalName());

        assertThrows(IllegalArgumentException.class, () -> hospital.setHospitalName(null));
        assertThrows(IllegalArgumentException.class, () -> hospital.setHospitalName("  "));

        hospital.setHospitalLocation(null);
        assertEquals("Unknown", hospital.getHospitalLocation());

        hospital.setHospitalContact(null);
        assertEquals("N/A", hospital.getHospitalContact());

        DiseaseList newList = new DiseaseList();
        hospital.setDiseaseList(newList);
        assertEquals(newList, hospital.getDiseaseList());

        hospital.setDiseaseList(null);
        assertNotNull(hospital.getDiseaseList());
    }

    @Test
    public void testToStringContainsExpectedInfo() {
        HospitalData hospital = new HospitalData("Hosp", "Loc", "Contact", diseaseList);
        String str = hospital.toString();

        assertTrue(str.contains("Hosp"));
        assertTrue(str.contains("Loc"));
        assertTrue(str.contains("Contact"));
        assertTrue(str.contains("diseaseCount=0"));
    }
}

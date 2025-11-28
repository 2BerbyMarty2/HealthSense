import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HospitalListTest {

    private HospitalList hospitalList;
    private HospitalData hosp1;
    private HospitalData hosp2;

    @BeforeEach
    public void setup() {
        hospitalList = new HospitalList();

        DiseaseList diseases1 = new DiseaseList();
        diseases1.addNode(new DiseaseData("Region1", "Flu", new int[]{1,2,3,4}));

        DiseaseList diseases2 = new DiseaseList();
        diseases2.addNode(new DiseaseData("Region2", "Cold", new int[]{5,6,7,8}));

        hosp1 = new HospitalData("Hospital One", "Location1", "12345", diseases1);
        hosp2 = new HospitalData("Hospital Two", "Location2", "67890", diseases2);
    }

    @Test
    public void testAddNodeAndIsEmpty() {
        assertTrue(hospitalList.isEmpty());

        hospitalList.addNode(hosp1);
        assertFalse(hospitalList.isEmpty());

        hospitalList.addNode(hosp2);
        assertFalse(hospitalList.isEmpty());
    }

    @Test
    public void testRemoveNodeByReference() {
        hospitalList.addNode(hosp1);
        hospitalList.addNode(hosp2);

        hospitalList.removeNode(hosp1);
        // After removal, only one node should remain and it should be hosp2
        assertFalse(hospitalList.isEmpty());
        assertTrue(hospitalList.searchHospitalByName("Hospital Two"));

        hospitalList.removeNode(hosp2);
        assertTrue(hospitalList.isEmpty());
    }

    @Test
    public void testRemoveHospitalByNameAndUndo() {
        hospitalList.addNode(hosp1);
        hospitalList.addNode(hosp2);

        boolean removed = hospitalList.removeHospital("Hospital One");
        assertTrue(removed);
        assertFalse(hospitalList.searchHospitalByName("Hospital One"));

        // Undo removal
        boolean undone = hospitalList.undoRemove();
        assertTrue(undone);
        assertTrue(hospitalList.searchHospitalByName("Hospital One"));

        // Undo again (undo stack empty)
        hospitalList.undoRemove(); // removes hosp2 implicitly?
        boolean undoFail = hospitalList.undoRemove();
        assertFalse(undoFail);
    }

    @Test
    public void testSearchHospitalByNameExistsAndNotExists() {
        hospitalList.addNode(hosp1);

        assertTrue(hospitalList.searchHospitalByName("Hospital One"));
        assertTrue(hospitalList.searchHospitalByName("hospital one")); // case-insensitive

        assertFalse(hospitalList.searchHospitalByName("Unknown Hospital"));
    }

    @Test
    public void testGetAllDiseaseReturnsMergedList() {
        hospitalList.addNode(hosp1);
        hospitalList.addNode(hosp2);

        DiseaseList merged = hospitalList.getAllDisease();
        assertNotNull(merged);

        // Should contain all diseases from hosp1 and hosp2
        assertEquals(2, merged.size());

        // Check disease names present in merged list
        boolean foundFlu = false;
        boolean foundCold = false;
        DiseaseList.Node current = merged.getHead();
        while (current != null) {
            String name = current.data.getDiseaseName().toLowerCase();
            if (name.equals("flu")) foundFlu = true;
            if (name.equals("cold")) foundCold = true;
            current = current.next;
        }
        assertTrue(foundFlu);
        assertTrue(foundCold);
    }
}

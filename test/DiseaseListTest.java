import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiseaseListTest {

    private DiseaseList diseaseList;
    private DiseaseData data1;
    private DiseaseData data2;
    private DiseaseData data3;

    @BeforeEach
    public void setup() {
        diseaseList = new DiseaseList();
        data1 = new DiseaseData("RegionA", "Flu", new int[]{10, 20, 30, 40});
        data2 = new DiseaseData("RegionB", "Cold", new int[]{5, 10, 15, 20});
        data3 = new DiseaseData("RegionA", "Flu", new int[]{1, 2, 3, 4}); // same disease name as data1, different counts
    }

    @Test
    public void testAddNodeAndSize() {
        assertTrue(diseaseList.isEmpty());
        diseaseList.addNode(data1);
        assertFalse(diseaseList.isEmpty());
        assertEquals(1, diseaseList.size());

        diseaseList.addNode(data2);
        assertEquals(2, diseaseList.size());
    }

    @Test
    public void testRemoveNode() {
        diseaseList.addNode(data1);
        diseaseList.addNode(data2);

        diseaseList.removeNode(data1);
        assertEquals(1, diseaseList.size());

        // Removing non-existing node should do nothing
        diseaseList.removeNode(data3);
        assertEquals(1, diseaseList.size());

        diseaseList.removeNode(data2);
        assertTrue(diseaseList.isEmpty());
    }

    @Test
    public void testAddNodeList() {
        DiseaseList listToAdd = new DiseaseList();
        listToAdd.addNode(data1);
        listToAdd.addNode(data2);

        diseaseList.addNodeList(listToAdd);
        assertEquals(2, diseaseList.size());

        // Add again to test appending
        diseaseList.addNodeList(listToAdd);
        assertEquals(4, diseaseList.size());
    }

    @Test
    public void testSearch() {
        diseaseList.addNode(data1);
        diseaseList.addNode(data2);
        diseaseList.addNode(data3);

        // Just call search (prints to console).
        // For better testing, refactor search to return results instead.
        diseaseList.search("flu");
        diseaseList.search("cold");
        diseaseList.search("unknown"); // no results, just totals 0
    }

    @Test
    public void testTotalNumberOfCases() {
        diseaseList.addNode(data1);
        diseaseList.addNode(data3); // same disease name "Flu"
        diseaseList.addNode(data2);

        // Call method (prints to console)
        diseaseList.totalNumberOfCases();
    }

    @Test
    public void testPrintAggregatedWeeklyCases() {
        diseaseList.addNode(data1);
        diseaseList.addNode(data2);
        diseaseList.addNode(data3);

        // Call method (prints to console)
        diseaseList.printAggregatedWeeklyCases();
    }
}

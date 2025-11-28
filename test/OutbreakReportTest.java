import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class OutbreakReportTest {

    private OutbreakReportQueue queue;
    private OutbreakReport report1;
    private OutbreakReport report2;

    @BeforeEach
    public void setup() {
        queue = new OutbreakReportQueue();

        report1 = new OutbreakReport(
                "Region1", "DiseaseA", 10, 100,
                LocalDate.of(2025, 8, 1), OutbreakReport.Severity.MODERATE);

        report2 = new OutbreakReport(
                "Region2", "DiseaseB", 11, 150,
                LocalDate.of(2025, 8, 2), OutbreakReport.Severity.SEVERE);
    }

    @Test
    public void testEnqueueAndSize() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        queue.enqueue(report1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        queue.enqueue(report2);
        assertEquals(2, queue.size());
    }

    @Test
    public void testPeek() {
        queue.enqueue(report1);
        queue.enqueue(report2);

        OutbreakReport peeked = queue.peek();
        assertEquals(report1, peeked);
        assertEquals(2, queue.size()); // peek does not remove element
    }

    @Test
    public void testDequeue() {
        queue.enqueue(report1);
        queue.enqueue(report2);

        OutbreakReport first = queue.dequeue();
        assertEquals(report1, first);
        assertEquals(1, queue.size());

        OutbreakReport second = queue.dequeue();
        assertEquals(report2, second);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeueEmptyThrows() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    public void testPeekEmptyThrows() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
    }
}

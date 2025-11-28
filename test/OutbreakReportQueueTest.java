import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutbreakReportQueueTest {

    private OutbreakReportQueue queue;
    private OutbreakReport sampleReport;

    @BeforeEach
    public void setUp() {
        queue = new OutbreakReportQueue();
        sampleReport = new OutbreakReport("Region1", "DiseaseX", 10, 50,
                java.time.LocalDate.now(), OutbreakReport.Severity.MODERATE);
    }

    @Test
    public void testQueueInitiallyEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueueIncreasesSize() {
        queue.enqueue(sampleReport);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    public void testDequeueReturnsCorrectElement() {
        queue.enqueue(sampleReport);
        OutbreakReport dequeued = queue.dequeue();
        assertEquals(sampleReport, dequeued);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeekReturnsFrontWithoutRemoving() {
        queue.enqueue(sampleReport);
        OutbreakReport peeked = queue.peek();
        assertEquals(sampleReport, peeked);
        assertEquals(1, queue.size());
    }

    @Test
    public void testDequeueOnEmptyThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    public void testPeekOnEmptyThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            queue.peek();
        });
    }

    @Test
    public void testMultipleEnqueueDequeue() {
        OutbreakReport report2 = new OutbreakReport("Region2", "DiseaseY", 12, 30,
                java.time.LocalDate.now(), OutbreakReport.Severity.SEVERE);
        queue.enqueue(sampleReport);
        queue.enqueue(report2);

        assertEquals(2, queue.size());

        OutbreakReport first = queue.dequeue();
        assertEquals(sampleReport, first);

        OutbreakReport second = queue.dequeue();
        assertEquals(report2, second);

        assertTrue(queue.isEmpty());
    }
}

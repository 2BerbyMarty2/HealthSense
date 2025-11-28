public class OutbreakReportQueue {

    // Node inner class for linked list nodes
    private static class Node {
        OutbreakReport data;
        Node next;

        Node(OutbreakReport data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Constructor
    public OutbreakReportQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // add to the end of the queue
    public void enqueue(OutbreakReport report) {
        Node newNode = new Node(report);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove
    public OutbreakReport dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        OutbreakReport result = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return result;
    }

    // Peek
    public OutbreakReport peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Check empty
    public boolean isEmpty() {
        return front == null;
    }

    // size
    public int size() {
        return size;
    }
}

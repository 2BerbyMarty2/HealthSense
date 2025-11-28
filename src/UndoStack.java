class UndoStack {
    private static class StackNode {
        HospitalData data;
        StackNode next;

        StackNode(HospitalData data) {
            this.data = data;
        }
    }

    private StackNode top;
    private int size = 0;
    private final int MAX_SIZE = 3;

    public void push(HospitalData data) {
        if (size == MAX_SIZE) {
            // Remove bottom-most node (oldest undo)
            removeOldest();
        }
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public HospitalData pop() {
        if (top == null) return null;
        HospitalData data = top.data;
        top = top.next;
        size--;
        return data;
    }

    private void removeOldest() {
        if (top == null || top.next == null) return;
        StackNode current = top;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

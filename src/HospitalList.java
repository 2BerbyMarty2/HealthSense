public class HospitalList {
    final private UndoStack undoStack = new UndoStack();
    static class Node {
        HospitalData data;
        Node next;

        Node(HospitalData hospitalData) {
            this.data = hospitalData;
            this.next = null;
        }
    }// end of Node class

    private Node head;

    // Add a node to the end
    public void addNode(HospitalData hospitalData) {
        Node node = new Node(hospitalData);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }// end of addNode

    // Remove the node by object reference (or override .equals() in HospitalData)
    public void removeNode(HospitalData hospitalData) {
        if (head == null) return;

        if (head.data == hospitalData) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == hospitalData) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }// end of removeNode



    public void displayHospitalNames() {
        if (head == null) {
            System.out.println("No hospitals to display.");
        }
        Node temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println("0" + i + ") " + temp.data.getHospitalName());
            temp = temp.next;
            i++;
        }
    }// end of displayHospitalNames

    public boolean isEmpty(){
        return head == null;
    }// end of isEmpty


    // remove hospital by name
    public boolean removeHospital(String nameToRemove) {
        if (head == null) {
            return false;
        }

        if (head.data.getHospitalName().equalsIgnoreCase(nameToRemove)) {
            undoStack.push(head.data); // Save for undo
            head = head.next;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.getHospitalName().equalsIgnoreCase(nameToRemove)) {
                undoStack.push(temp.next.data); // Save for undo
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }// end of remove hospital by name

    public boolean undoRemove() {
        if (undoStack.isEmpty()) {
            System.out.println("No operations to undo.");
            return false;
        }

        HospitalData dataToRestore = undoStack.pop();
        addNode(dataToRestore);
        System.out.println("Undo successful: Restored hospital → " + dataToRestore.getHospitalName());
        return true;
    }

    public DiseaseList getAllDisease() {

        DiseaseList mergedList = new DiseaseList();
        Node current = head;

        while (current != null) {
            DiseaseList hospitalDiseases = current.data.getDiseaseList();
            DiseaseList.Node temp = hospitalDiseases.getHead(); // assuming this gets the first node

            while (temp != null) {
                mergedList.addNode(temp.data); // copy data, don't reuse node
                temp = temp.next;
            }

            current = current.next;
        }

        return mergedList;
    }
    public boolean searchHospitalByName(String name) {
        if (head == null) {
            System.out.println("No hospitals available.");
            return false;
        }

        Node temp = head;
        int i = 1;
        while (temp != null) {
            if (temp.data.getHospitalName().equalsIgnoreCase(name)) {
                System.out.println("---------------------------");
                System.out.println("0" + i + ") " + temp.data.getHospitalName());
                System.out.println("Location: " + temp.data.getHospitalLocation());
                System.out.println("Contact : " + temp.data.getHospitalContact());

                DiseaseList diseaseList = temp.data.getDiseaseList();
                if (diseaseList != null && !diseaseList.isEmpty()) {
                    System.out.println("Diseases:");
                    DiseaseList.Node diseaseNode = diseaseList.getHead();
                    int diseaseIndex = 1;
                    while (diseaseNode != null) {
                        System.out.println("\n  • Disease " + diseaseIndex + ":");
                        diseaseNode.data.display(); // Use the display() from DiseaseData
                        diseaseNode = diseaseNode.next;
                        diseaseIndex++;
                    }
                } else {
                    System.out.println("Diseases: None");
                }

                return true;
            }

            temp = temp.next;
            i++;
        }

        System.out.println("Hospital not found: " + name);
        return false;
    }


}// end of class
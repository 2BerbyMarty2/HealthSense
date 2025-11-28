import java.util.ArrayList;

public class DiseaseList {


    public boolean isEmpty() {
        return head == null;
    }

    static class Node {
        DiseaseData data;
        Node next;

        Node (DiseaseData data){
            this.data = data;
            this.next = null;
        }
    }// end of Node class

    private Node head;

    // add a node at the end
    public void addNode(DiseaseData diseaseData){
        Node node = new Node(diseaseData);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //Add a whole list of nodes
    public void addNodeList(DiseaseList list){
        Node temp = list.head;
        while(temp != null){
            addNode(temp.data);
            temp = temp.next;
        }
    }

    // Remove the node by object reference ()
    public void removeNode(DiseaseData diseaseData) {
        if (head == null) return;

        if (head.data == diseaseData) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == diseaseData) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    public Node getHead() {
        return head;
    }

    public void displayList() {
        Node temp = head;
        while(temp != null){
            System.out.println("----------------------------------");
            System.out.println("Name: " + temp.data.getDiseaseName());
            System.out.println("Region: " + temp.data.getRegion());
            System.out.println("Case Count: " + temp.data.getCaseCountAll());
            System.out.println("Cases per week:");
            for (int i = 0; i < temp.data.getCasesPerWeek().length; i++){
                System.out.print("Week 0" + (i+1) + ": ");
                System.out.println("  " + temp.data.getCasesPerWeek()[i]);
            }
            temp = temp.next;
        }
    }

    public void search(String name) {
        Node temp = head;
        int fullCount = 0;
        while (temp != null) {
            if (temp.data.getDiseaseName().equalsIgnoreCase(name)) {
                System.out.println("----------------Case found------------------");
                System.out.println("Name: " + temp.data.getDiseaseName());
                System.out.println("Region: " + temp.data.getRegion());
                System.out.println("Case Count: " + temp.data.getCaseCountAll());
                System.out.println("Cases per week:");
                int[] weeklyCases = temp.data.getCasesPerWeek();

                fullCount += temp.data.getCaseCountAll();

                for (int i = 0; i < weeklyCases.length; i++) {
                    System.out.printf("  Week %02d: %d%n", (i + 1), weeklyCases[i]);
                }

            }
            temp = temp.next;

        }
        System.out.println("\nTotal cases: " + fullCount);
    }// end of search method

    public int size(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }


    public void totalNumberOfCases(){
        if (head == null){
            System.out.println("No data to display.");
            return;
        }

        Node temp = head;
        ArrayList<String> diseaseNames = new ArrayList<>();
        ArrayList<Integer> totalCounts = new ArrayList<>();

        while(temp != null){
            String name = temp.data.getDiseaseName();
            int sum = temp.data.getCaseCountAll();

            int index = diseaseNames.indexOf(name);
            if (index != -1) {
                totalCounts.set(index, totalCounts.get(index) + sum);
            } else {
                diseaseNames.add(name);
                totalCounts.add(sum);
            }

            temp = temp.next;
        }

        for (int i = 0; i < diseaseNames.size(); i++) {
            System.out.println(diseaseNames.get(i) + " -> Total cases: " + totalCounts.get(i));
        }
    }// end of totalNumberOfCases method

    public void printAggregatedWeeklyCases() {
        if (head == null) {
            System.out.println("No data to display.");
            return;
        }

        ArrayList<String> diseaseNames = new ArrayList<>();
        ArrayList<int[]> weeklyTotals = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            String diseaseName = temp.data.getDiseaseName();
            int[] weeklyCases = temp.data.getCasesPerWeek();

            if (weeklyCases == null || weeklyCases.length < 4) {
                temp = temp.next;
                continue; // skip invalid data
            }

            // Case-insensitive search for existing disease name
            int index = -1;
            for (int i = 0; i < diseaseNames.size(); i++) {
                if (diseaseNames.get(i).equalsIgnoreCase(diseaseName)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                // Disease exists, add to its weekly total
                int[] totals = weeklyTotals.get(index);
                for (int w = 0; w < 4; w++) {
                    totals[w] += weeklyCases[w];
                }
            } else {
                // New disease, add to both lists
                diseaseNames.add(diseaseName);
                weeklyTotals.add(new int[]{
                        weeklyCases[0], weeklyCases[1], weeklyCases[2], weeklyCases[3]
                });
            }

            temp = temp.next;
        }

        // Print summary table
        System.out.println("Aggregated Disease Cases by Week:");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s%n", "Disease", "Week 1", "Week 2", "Week 3", "Week 4");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < diseaseNames.size(); i++) {
            int[] weeks = weeklyTotals.get(i);
            System.out.printf("%-15s %-10d %-10d %-10d %-10d%n",
                    diseaseNames.get(i), weeks[0], weeks[1], weeks[2], weeks[3]);
        }
    }// end of printAggregatedWeeklyCases method

    public void BSTTraversal() {
        if (head == null) {
            System.out.println("No data to display.");
            return;
        }

        Node temp = head;
        ArrayList<String> diseaseNames = new ArrayList<>();
        ArrayList<Integer> totalCounts = new ArrayList<>();
        DiseaseBST bst = new DiseaseBST();

        while (temp != null) {
            String name = temp.data.getDiseaseName();
            int sum = temp.data.getCaseCountAll();

            int index = diseaseNames.indexOf(name);
            if (index != -1) {
                totalCounts.set(index, totalCounts.get(index) + sum);
            } else {
                diseaseNames.add(name);
                totalCounts.add(sum);
            }

            temp = temp.next;
        }

        // Insert into BST
        for (int i = 0; i < diseaseNames.size(); i++) {
            bst.insert(diseaseNames.get(i), totalCounts.get(i));
        }

        // traversal
        System.out.println("In-order Traversal:");
        bst.inOrder();

        System.out.println("\nPre-order Traversal:");
        bst.preOrder();

        System.out.println("\nPost-order Traversal:");
        bst.postOrder();
    }// end of BSTTraversal method





}// end class
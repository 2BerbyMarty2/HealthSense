// Define the BST Node
class BSTNode {
    String diseaseName;
    int totalCases;
    BSTNode left, right;

    BSTNode(String diseaseName, int totalCases) {
        this.diseaseName = diseaseName;
        this.totalCases = totalCases;
        left = right = null;
    }

    String getSeverity() {
        if (totalCases <= 20) return "Mild";
        else if (totalCases <= 50) return "Moderate";
        else return "Severe";
    }
}

// Binary Search Tree for disease classification
class DiseaseBST {
    BSTNode root;

    void insert(String name, int cases) {
        root = insertRec(root, name, cases);
    }

    private BSTNode insertRec(BSTNode node, String name, int cases) {
        if (node == null) return new BSTNode(name, cases);
        if (cases < node.totalCases)
            node.left = insertRec(node.left, name, cases);
        else
            node.right = insertRec(node.right, name, cases);
        return node;
    }

    void inOrder() {
        inOrderRec(root);
    }

    void preOrder() {
        preOrderRec(root);
    }

    void postOrder() {
        postOrderRec(root);
    }

    private void inOrderRec(BSTNode node) {
        if (node != null) {
            inOrderRec(node.left);
            printNode(node);
            inOrderRec(node.right);
        }
    }

    private void preOrderRec(BSTNode node) {
        if (node != null) {
            printNode(node);
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    private void postOrderRec(BSTNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            printNode(node);
        }
    }

    private void printNode(BSTNode node) {
        System.out.println(node.diseaseName + " -> Total: " + node.totalCases +
                " | Severity: " + node.getSeverity());
    }
}
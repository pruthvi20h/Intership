class TreeNode {
    int value;
    TreeNode left, right;

    // Constructor
    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}
public class BinarySearchTree {
    private TreeNode root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a new value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        // return the (unchanged) node pointer
        return root;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value) {
        // Base case: root is null or value is present at the root
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        // Value is greater than root's value
        if (value > root.value) {
            return searchRec(root.right, value);
        }

        // Value is smaller than root's value
        return searchRec(root.left, value);
    }

    // Delete a value from the BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private TreeNode deleteRec(TreeNode root, int value) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Recur down the tree
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // This node needs to be deleted

            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    // Get the minimum value node in the right subtree
    private int minValue(TreeNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal (Left, Root, Right)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting nodes into the BST
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Perform in-order, pre-order, and post-order traversals
        System.out.println("In-order traversal:");
        tree.inorder();  // Output should be sorted

        System.out.println("Pre-order traversal:");
        tree.preorder();

        System.out.println("Post-order traversal:");
        tree.postorder();

        // Search for a value
        System.out.println("Searching for 40: " + tree.search(40));  // Should return true
        System.out.println("Searching for 25: " + tree.search(25));  // Should return false

        // Deleting a node
        System.out.println("Deleting 20:");
        tree.delete(20);
        tree.inorder();  // 20 should be removed

        System.out.println("Deleting 30:");
        tree.delete(30);
        tree.inorder();  // 30 should be removed

        System.out.println("Deleting 50:");
        tree.delete(50);
        tree.inorder();  // 50 should be removed
    }
}
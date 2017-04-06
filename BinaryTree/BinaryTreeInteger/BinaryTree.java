public class BinaryTree {
    private TreeNode root;

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        public TreeNode() {
            this.left = null;
            this.right = null;
            this.data = 0;
        }
        public TreeNode(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    /**
     * Insert data to tree
     * @param node root of the tree to be inserted
     * @param data data to be inserted
     * @return root of the updated tree
     */
    private TreeNode insert(TreeNode node, int data) {
        if (node == null) return new TreeNode(data);
        if (data <= node.data) node.left = insert(node.left, data);
        else node.right = insert(node.right, data);
        return node;
    }

    /**
     * Insert data to tree
     * @param data
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Build a tree from array
     * @param array
     */
    public void build (int[] array) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    /**
     * Output tree data inorder
     * @param node root of the tree
     * @return
     */
    private String toString(TreeNode node) {
        StringBuilder str = new StringBuilder();
        if (node != null) {
            str.append(toString(node.left));
            str.append(node.data + " ");
            str.append(toString(node.right));
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return toString(root);
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4};
        BinaryTree tree = new BinaryTree();
        System.out.println(tree.toString());
        tree.build(array);
        System.out.println(tree.toString());
    }
}

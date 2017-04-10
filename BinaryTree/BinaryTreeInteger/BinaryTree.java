import java.util.*;

public class BinaryTree {
    private TreeNode root;

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        public TreeNode() {}
        public TreeNode(int data) {this.data = data;}
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
     * Build a binary search tree from array
     * @param array
     */
    public void buildBST (int[] array) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    public void buildMinDepthBT (int[] array) {

    }

    public void buildBalancedBT (int[] array) {

    }

    // Compared with DFS, do not need visited set, do not need peek()
    public List<Integer> bfs1() {

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.data);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return list;
    }


    public List<List<Integer>> bfs2() {


        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> sublist = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sublist.add(node.data);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            list.add(sublist);

        }

        return list;


    }

    /**
     * DFS preorder method 1, use a visited set, visited when push, add to list when push
     * @return
     */
    public List<Integer> dfsPreOrder1() {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        list.add(root.data);
        visited.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                list.add(node.left.data);
                visited.add(node.left);
            }
            else if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
                list.add(node.right.data);
                visited.add(node.right);
            }
            else {
                stack.pop();
            }
        }

        return list;

    }

    /**
     * DFS preorder method 2, no visited set, add to list when pop, push right first
     * @return
     */
    public List<Integer> dfsPreOrder2() {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.data);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return list;
    }

    /**
     * DFS preorder method 3, recursive
     * @return
     */
    public List<Integer> dfsPreOrder3() {
        return dfsPreOrderRecursive(root);
    }

    private List<Integer> dfsPreOrderRecursive(TreeNode node) {
        if (node == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        list.add(node.data);
        list.addAll(dfsPreOrderRecursive(node.left));
        list.addAll(dfsPreOrderRecursive(node.right));

        return list;
    }



    /**
     * DFS postorder method 1
     * @return
     */
    public List<Integer> dfsPostOrder1() {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);

        visited.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                visited.add(node.left);
            }
            else if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
                visited.add(node.right);
            }
            else {
                TreeNode top = stack.pop();
                list.add(top.data);
            }
        }

        return list;

    }

    /**
     * DFS postorder method 2
     * @return
     */
    public List<Integer> dfsPostOrder2() {
        return dfsPostOrderRecursive(root);
    }

    private List<Integer> dfsPostOrderRecursive(TreeNode node) {
        if (node == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.addAll(dfsPostOrderRecursive(node.left));
        list.addAll(dfsPostOrderRecursive(node.right));
        list.add(node.data);
        return list;
    }



    public void dfsInOrder() {

    }

    public void dfsInOrderRecursive() {

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
        int[] array = {1, 0, 3, 2, 4};
        BinaryTree tree = new BinaryTree();
        System.out.println(tree.toString());
        tree.buildBST(array);
        System.out.println(tree.toString());

        System.out.print("\n DFS preorder traversal1: ");
        List<Integer> traversalList = tree.dfsPreOrder1();
        for (int i : traversalList) {
            System.out.print(i + " ");
        }

        System.out.print("\n DFS preorder traversal2: ");
        traversalList = tree.dfsPreOrder2();
        for (int i : traversalList) {
            System.out.print(i + " ");
        }

        System.out.print("\n DFS preorder traversal3: ");
        traversalList = tree.dfsPreOrder3();
        for (int i : traversalList) {
            System.out.print(i + " ");
        }

        System.out.print("\n DFS bfs traversal: ");
        traversalList = tree.bfs1();
        for (int i : traversalList) {
            System.out.print(i + " ");
        }

        System.out.print("\n DFS level traversal: ");
        List<List<Integer>> levelOrderTraversal = tree.bfs2();
        for (int level = 0; level < levelOrderTraversal.size(); level++) {
            System.out.print("\n level " + level + ": ");
            for (int i : levelOrderTraversal.get(level)) {
                System.out.print(i + " ");
            }
        }
        //       1
        //     0   3
        //       2   4
    }
}

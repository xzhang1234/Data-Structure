
import java.util.*;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    private static class TreeNode<T extends Comparable<T>> {
        TreeNode<T> left;
        TreeNode<T> right;
        T data;

        public TreeNode() {
            this.left = null;
            this.right = null;
            this.data = null;
        }

        public TreeNode(T data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }

    }


    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) return (new TreeNode<T>(data));

        if (data.compareTo(node.data) <= 0) node.left = insert(node.left, data);
        else node.right = insert(node.right, data);

        return node;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    public void build(T[] array){
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    private String toString(TreeNode<T> node) {
        StringBuilder str = new StringBuilder();
        if (node != null) {
            str.append(toString(node.left));
            str.append(node.data.toString() + " ");
            str.append(toString(node.right));
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return toString(root);
    }


    public static void main(String[] args) {
        Integer[] array = {1, 3, 2, 4};
        BinaryTree<Integer> tree = new BinaryTree();
        System.out.println(tree);
        tree.build(array);
        System.out.println(tree);
    }

}






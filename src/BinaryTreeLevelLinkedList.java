import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelLinkedList {

    private static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(70);
        root.right = new TreeNode(150);

        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(80);

        root.right.left = new TreeNode(120);
        root.right.right = new TreeNode(170);

        return root;
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data + " ");
            inOrderTraversal(root.right);
        }
    }


    private static ArrayList<ArrayList<Integer>> createLevelLinkedList(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return null;

        queue.add(root);

        while (!queue.isEmpty()) {

            Queue<TreeNode> tempQueue = new LinkedList<>();


            ArrayList<Integer> current = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode tn = queue.remove();
                current.add(tn.data);

                if (tn.left != null)
                    tempQueue.add(tn.left);
                if (tn.right != null)
                    tempQueue.add(tn.right);
            }
            result.add(current);

            queue = tempQueue;
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        inOrderTraversal(root);

        ArrayList<ArrayList<Integer>> result = createLevelLinkedList(root);

        for(ArrayList<Integer> list: result)
        {
            System.out.println(list);
        }
    }
}

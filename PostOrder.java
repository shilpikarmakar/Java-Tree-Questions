import java.util.*;

class BinaryTree<T> {
    T data;
    BinaryTree<T> left; // left child reference
    BinaryTree<T> right; // right child reference

    BinaryTree(T data) {
        this.data = data;
        // default left and right are null
    }
}

class BinaryTreeOperations {
    String msg = "root";
    Scanner sc = new Scanner(System.in);
    int parent = -1;

    BinaryTree<Integer> insert() {
        System.out.println("Enter the data for " + msg + " node and parent is " + parent + ": \nTo exit enter -1");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTree<Integer> node = new BinaryTree<>(data);
        parent = data;
        msg = "left";
        node.left = insert();
        msg = "right";
        parent = data;
        node.right = insert();
        parent = data;
        msg = "root";
        return node;
    }
    void postOrderIterative(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            BinaryTree<Integer> node = stack.pop();
            list.add(node.data);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        System.out.println(list);
    }
}

public class PostOrder {
    public static void main(String[] args) {
        BinaryTreeOperations opr = new BinaryTreeOperations();
        BinaryTree<Integer> root = opr.insert();
        opr.postOrderIterative(root);
    }
}
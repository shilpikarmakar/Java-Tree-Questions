import java.util.Scanner;

class BinaryTree<T> {
    T data;
    int children = 0;
    BinaryTree arr[];

    BinaryTree(T data, int childrenCount) {
        this.data = data;
        this.children = childrenCount;
        arr = new BinaryTree[childrenCount];
    }
}

class TreeOperations {
    int msg = 0;
    Scanner sc = new Scanner(System.in);
    int parent = -1;

    BinaryTree<Integer> insert() {
        System.out.println("Enter the data for node " + msg + " of " + parent + ": \nTo exit enter -1");
        int data = sc.nextInt();

        // termination case
        if (data == -1) {
            return null;
        }
        // create a parent node (root Node)
        BinaryTree<Integer> node = new BinaryTree<>(data, 4);
        for (int i = 0; i < node.children; i++) {
            msg = i + 1;
            parent = data;
            node.arr[i] = insert();
        }
        msg = 0;
        parent = data;
        return node;
    }

    void print(BinaryTree<Integer> currentNode) {
        // termination case
        if (currentNode == null) {
            return;
        }
        String output = "";
        output += currentNode.data + " => ";
        for (int i = 0; i < currentNode.children; i++)
            if (currentNode.arr[i] != null)
                output += "Child " + (i + 1) + ": " + currentNode.arr[i].data + ", ";

        System.out.println(output);
        for (int i = 0; i < currentNode.children; i++)
            print(currentNode.arr[i]);
    }
}

public class BinaryTreeWithNChildren {
    public static void main(String[] args) {
        TreeOperations opr = new TreeOperations();
        BinaryTree<Integer> root = opr.insert();
        opr.print(root);
    }
}
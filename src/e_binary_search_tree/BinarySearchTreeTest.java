package e_binary_search_tree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(10);
        binarySearchTree.insert(15);
        binarySearchTree.insert(20);
        binarySearchTree.insert(25);
        binarySearchTree.insert(30);


        System.out.println(binarySearchTree.contains(30));
        System.out.println(binarySearchTree.contains(31));
    }
}

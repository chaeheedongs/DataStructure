package i_recursion;

public class RecursionCompleteBinarySearchTreeTest {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Recursion Binary Search Tree Insert");
        System.out.println("-----------------------------------");
        RecursionCompleteBinarySearchTree recursionBinarySearchTree = new RecursionCompleteBinarySearchTree();
        recursionBinarySearchTree.recursionInsert(2);
        recursionBinarySearchTree.recursionInsert(1);
        recursionBinarySearchTree.recursionInsert(3);

        System.out.println(recursionBinarySearchTree.getRoot().data);
        System.out.println(recursionBinarySearchTree.getRoot().left.data);
        System.out.println(recursionBinarySearchTree.getRoot().right.data);

        System.out.println();
        System.out.println("Recursion Binary Search Tree Contains");
        System.out.println("-----------------------------------");
//        recursionBinarySearchTree.recursionContains(3);


        System.out.println();
        System.out.println("Recursion Binary Search Tree Remove");
        System.out.println("-----------------------------------");

    }
}

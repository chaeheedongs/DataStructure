package c_linked_list;

public class SinglyLinkedListTest {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList(0);

        System.out.println();
        System.out.println("SinglyLinkedList Append");
        System.out.println("-----------------------");
        list.append(1);
        list.append(2);
        list.append(3);
        list.print(); // [0, 1, 2, 3]


        System.out.println();
        System.out.println("SinglyLinkedList Remove Last");
        System.out.println("----------------------------");
        list.removeLast();
        list.print(); // [0, 1, 2]


        System.out.println();
        System.out.println("SinglyLinkedList Prepend");
        System.out.println("------------------------");
        list.prepend(10);
        list.print(); // [10, 0, 1, 2]


        System.out.println();
        System.out.println("SinglyLinkedList Remove First");
        System.out.println("-----------------------------");
        list.removeFirst();
        list.print();  // [0, 1, 2]


        System.out.println();
        System.out.println("SinglyLinkedList Insert");
        System.out.println("-----------------------");
        list.insert(1, 10);
        list.print(); // [0, 10, 1, 2]


        System.out.println();
        System.out.println("SinglyLinkedList Remove");
        System.out.println("-----------------------");
        list.remove(1);
        list.print(); // [0, 1, 2]


        System.out.println();
        System.out.println("SinglyLinkedList Reverse");
        System.out.println("------------------------");

    }
}

package c_linked_list;

public class DoublyLinkedListTest {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList(0);

        System.out.println();
        System.out.println("DoublyLinkedList Append");
        System.out.println("-----------------------");
        list.append(1);
        list.append(2);
        list.append(3);
        list.print(); // [0, 1, 2, 3]


        System.out.println();
        System.out.println("DoublyLinkedList Remove Last");
        System.out.println("----------------------------");
        list.removeLast();
        list.print(); // [0, 1, 2]


        System.out.println();
        System.out.println("DoublyLinkedList Prepend");
        System.out.println("------------------------");
        list.prepend(10);
        list.print(); // [10, 0, 1, 2]


        System.out.println();
        System.out.println("DoublyLinkedList Remove First");
        System.out.println("-----------------------------");
        list.removeFirst();
        list.print();  // [0, 1, 2]


        System.out.println();
        System.out.println("DoublyLinkedList Insert");
        System.out.println("-----------------------");
        list.insert(1, 10);
        list.print(); // [0, 10, 1, 2]


        System.out.println();
        System.out.println("DoublyLinkedList Remove");
        System.out.println("-----------------------");
        list.remove(2);
        list.print(); // [0, 1, 2]


        System.out.println();
        System.out.println("DoublyLinkedList Reverse");
        System.out.println("------------------------");
    }
}

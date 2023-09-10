package h_heap;

public class HeapTest {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Heap Insert");
        System.out.println("-----------------------");
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.print();

        heap.insert(10);
        heap.print();

        heap.insert(7);
        heap.print();


        System.out.println();
        System.out.println("Heap Remove");
        System.out.println("-----------------------");
        heap.remove();
        heap.print();

        heap.remove();
        heap.print();

        heap.remove();
        heap.print();
    }
}

package d_queue_stack;

public class QueueTest {

    public static void main(String[] args) {

        Queue queue = new Queue(0);

        System.out.println();
        System.out.println("Queue Enqueue");
        System.out.println("-----------------------");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print(); // [0, 1, 2, 3]


        System.out.println();
        System.out.println("Queue Dequeue");
        System.out.println("-----------------------");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print(); // [3]

//        queue.getRear();
//        queue.getFront();
//        queue.getCount();
//        queue.print();
    }
}

package d_queue_stack;

public class StackTest {

    public static void main(String[] args) {

        Stack stack = new Stack(0);

        System.out.println();
        System.out.println("Stack push");
        System.out.println("-----------------------");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print(); // [4, 3, 2, 1, 0]



        System.out.println();
        System.out.println("Stack pop");
        System.out.println("-----------------------");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print(); // [1, 0]
//        stack.getTop();
//        stack.getCount();
//        stack.print();
    }
}

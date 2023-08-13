package d_queue_stack;

public class Queue {

    private QueueNode rear;
    private QueueNode front;
    private int count;


    // Constructor
    public Queue(Object data) {
        QueueNode newNode = new QueueNode(data);
        this.rear = newNode;
        this.front = newNode;
        this.count = this.count + 1;
    }


    class QueueNode {
        Object data;
        QueueNode nextNode;

        // Constructor
        public QueueNode(Object data) {
            this.data = data;
            this.nextNode = null;
        }
    }


    public void enqueue(Object data) {

        // 새로운 노드를 생성
        QueueNode newNode = new QueueNode(data);

        // 데이터가 없다면 rear, front에 newNode 할당
        if (this.count == 0) {
            this.rear = newNode;
            this.front = newNode;
        }
        // 데이터가 있다면 front의 다음 노드와 front에 newNode 할당
        else {
            this.front.nextNode = newNode;
            this.front = newNode;
        }

        // 총 길이 1 증가
        this.count = this.count + 1;
    }


    public QueueNode dequeue() {

        // 데이터가 없다면 null 리턴
        if (this.count == 0) {
            return null;
        }

        QueueNode tmpNode = this.rear;

        // 데이터가 1개라면 rear, front 제거
        if (this.count == 1) {
            this.rear = null;
            this.front = null;
        }
        // 데이터가 여러개라면 rear를 rear의 다음 노드로 할당 후 tmpNode의 다음 노드 제거
        else {
            this.rear = this.rear.nextNode;
            tmpNode.nextNode = null;
        }

        // 총 길이 1 감소
        this.count = this.count - 1;

        return tmpNode;
    }

    public void print() {
        QueueNode tmpNode = this.rear;

        while (tmpNode != null) {
            System.out.println(tmpNode.data);
            tmpNode = tmpNode.nextNode;
        }
    }

    public void getRear() {
        Object data = this.rear.data;
        System.out.println("rear = " + data);
    }

    public void getFront() {
        Object data = this.front.data;
        System.out.println("front = " + data);
    }

    public void getCount() {
        int count = this.count;
        System.out.println("count = " + count);
    }
}

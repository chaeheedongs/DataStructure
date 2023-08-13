package d_queue_stack;

public class Stack {

    private StackNode top;
    private int count;


    // Constructor
    public Stack(Object data) {
        StackNode newNode = new StackNode(data);
        this.top = newNode;
        this.count = this.count + 1;
    }


    class StackNode {
        Object data;
        StackNode nextNode;

        // Constructor
        public StackNode(Object data) {
            this.data = data;
            this.nextNode = null;
        }
    }


    public void push(Object data) {

        // 새로운 노드를 생성
        StackNode newNode = new StackNode(data);

        // 데이터가 없다면
        if (this.count == 0) {
            this.top = newNode;
        }
        // 데이터가 있다면
        else {
            newNode.nextNode = this.top;
            this.top = newNode;
        }

        // 총 길이 1 증가
        this.count = this.count + 1;
    }


    public StackNode pop() {

        // 데이터가 없다면 null 반환
        if (this.count == 0) {
            return null;
        }

        // 맨 위 데이터를 기준으로 노드를 생성 후
        // top을 다음 노드로 할당 후
        // 기존 노드의 다음 노드를 null로 할당
        StackNode tmp = this.top;
        this.top = this.top.nextNode;
        tmp.nextNode = null;

        // 총 길이 1 감소
        this.count = this.count - 1;

        return tmp;
    }


    public void print() {
        StackNode tmpNode = this.top;

        while (tmpNode != null) {
            System.out.println(tmpNode.data);
            tmpNode = tmpNode.nextNode;
        }
    }

    public void getTop() {
        Object data = this.top.data;
        System.out.println("top = " + data);
    }

    public void getCount() {
        int count = this.count;
        System.out.println("count = " + count);
    }
}

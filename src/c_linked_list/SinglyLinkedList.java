package c_linked_list;

// outer class
public class SinglyLinkedList {

    private SinglyNode head; // 맨 앞 노드
    private SinglyNode tail; // 맨 뒤 노드
    private int count;       // List 총 길이


    // inner class
    protected class SinglyNode {

        Object data;         // 데이터
        SinglyNode nextNode; // 다음 노드

        // Constructor
        SinglyNode(Object data) {
            this.data = data;
            this.nextNode = null;
        }
    }


    // Constructor
    public SinglyLinkedList(Object data) {

        // 새로운 노드를 생성
        SinglyNode newNode = new SinglyNode(data);

        // Node 가 없을 때
        if (this.count == 0) {
            this.head = newNode; // 맨 앞 노드에 할당
            this.tail = newNode; // 맨 뒤 노드에 할당
        }

        // 작업을 마친 후 총 길이 1 증가
        this.count = this.count + 1;
    }


    /**
     * Append <p>
     *  - LinkedList의 맨 마지막 부분에 데이터를 추가 <p>
     *  - O(1)
     * -----------------------------------------------
     * <pre>
     *     {
     *         "data": data,
     *         "nextNode": null
     *     }
     * </pre>
     */
    public void append(Object data) {

        // 새로운 노드를 생성
        SinglyNode newNode = new SinglyNode(data);

        // 데이터가 없다면 Head와 Tail에 새로운 노드를 연결
        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        }
        // 데이터가 있다면 Tail의 다음 노드와 현재 Tail에 새로운 노드를 연결
        else {
            this.tail.nextNode = newNode;
            this.tail = newNode;
        }

        // 총 길이 1 증가
        this.count = this.count + 1;
    }


    /**
     * Remove Last <p>
     * - LinkedList의 맨 마지막 부분에 데이터를 제거 <p>
     * - O(n) <p>
     * -----------------------------------------------
     */
    public SinglyNode removeLast() {

        // 데이터가 없다면 null 리턴
        if (this.count == 0) {
            return null;
        }

        // 데이터가 1개 이상 이라면
        SinglyNode currentNode = this.head;
        SinglyNode swapNode = this.head;

        // 다음 노드가 존재 한다면
        while (currentNode.nextNode != null) {
            // 다음 노드로 이동
            swapNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        // swap Node를 현재 노드로 지정 후 다음 노드를 제거
        currentNode = swapNode;
        currentNode.nextNode = null;

        // 총 길이 1 감소
        this.count = this.count - 1;

        // 갯수가 0개가 되었을 때 모든 노드를 제거
        if (this.count == 0) {
            this.head = null;
            this.tail = null;
        }

        // 현재 노드를 반환
        return currentNode;
    }


    /**
     * Prepend <p>
     * - LinkedList의 맨 첫 부분에 데이터를 추가 <p>
     * - O(1) <p>
     * -----------------------------------------------
     */
    public void prepend(Object data) {

        // 새로운 노드를 생성
        SinglyNode newNode = new SinglyNode(data);

        // 데이터가 없다면 Head와 Tail에 새로운 노드를 연결
        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        }
        // 데이터가 있다면 newNode의 다음 노드를 현재 Head 로 변경 후,
        // 현재 Head를 newNode로 변경
        else {
            newNode.nextNode = this.head;
            this.head = newNode;
        }

        // 총 길이 1 증가
        this.count = this.count + 1;
    }


    /**
     * Remove First <p>
     * - LinkedList의 맨 첫 부분에 데이터를 제거 <p>
     * - O(1)
     * -----------------------------------------------
     */
    public SinglyNode removeFirst() {

        // 데이터가 없다면 null 리턴
        if (this.count == 0) {
            return null;
        }

        // swap용 Node 할당
        SinglyNode swapNode = this.head;

        this.head = this.head.nextNode; // 현재 Head를 nextNode로 할당
        swapNode.nextNode = null;       // 이전 Node의 nextNode에 null 할당

        // 총 길이 1 감소
        this.count = this.count - 1;

        // 갯수가 0개가 되었을 때 모든 노드를 제거
        if (this.count == 0) {
            this.tail = null;
        }

        return swapNode;
    }


    /**
     * Get <p>
     * - LinkedList의 인덱스 조회 <p>
     * - O(n)
     * -----------------------------------------------
     */
    public SinglyNode get(int index) {

        // 데이터가 없다면 null 리턴
        if (this.count == 0) {
            return null;
        }

        // 찾으려는 index가 0보다 작거나 count보다 크면 null을 반환
        if (index < 0 || index >= this.count) {
            return null;
        }

        // 첫 노드를 swapNode에 저장
        SinglyNode swapNode = this.head;

        // 찾으려는 index 길이만큼 노드 이동
        for (int i = 0; i < index; i++) {
            swapNode = swapNode.nextNode;
        }

        return swapNode;
    }


    /**
     * Set <p>
     * - LinkedList의 인덱스에 데이터를 수정 <p>
     * - O(n) <p>
     * -----------------------------------------------
     */
    public boolean set(int index, Object data) {

        // 수정하려는 index의 Node를 조회
        SinglyNode findNode = get(index);

        // 찾은 Node의 데이터가 존재한다면 데이터를 수정
        if (findNode != null) {
            findNode.data = data;
            return true;
        }

        return false;
    }

    /**
     * Insert <p>
     * - LinkedList의 인덱스에 데이터를 추가 <p>
     * - O(n) <p>
     * -----------------------------------------------
     */
    public boolean insert(int index, Object data) {

        // 찾으려는 index가 0보다 작거나 count보다 크면 false를 반환
        if (index < 0 || index > this.count) {
            return false;
        }

        // 데이터가 없다면 맨 앞에 데이터를 추가
        if (this.count == 0) {
            prepend(data);
            return true;
        }

        // Node의 개수와 index가 일치한다면 맨 뒤에 데이터를 추가
        if (this.count == index) {
            append(data);
            return true;
        }

        // 중간에 있다면
        SinglyNode newNode = new SinglyNode(data); // 새로운 Node를 생성
        SinglyNode findNode = get(index - 1);      // 해당 Index Node를 조회

        newNode.nextNode = findNode.nextNode;      // 새로운 Node의 nextNode를 변경
        findNode.nextNode = newNode;               // 조회한 Node의 nextNode를 새로운 Node로 변경

        // 총 길이 1 증가
        this.count = this.count + 1;

        return true;
    }


    /**
     * Remove <p>
     * - LinkedList의 인덱스에 데이터를 제거 <p>
     * - O(n) <p>
     * -----------------------------------------------
     */
    public SinglyNode remove(int index) {

        // 찾으려는 index가 0보다 작거나 count보다 크면 null을 반환
        if (index < 0 || index >= this.count) {
            return null;
        }

        // index가 0이면 첫 번째 제거
        if (index == 0) {
            return removeFirst();
        }

        // Node의 개수와 index가 일치한다면 맨 뒤에 데이터를 제거
        if (this.count == index) {
            return removeLast();
        }

        SinglyNode findNode = get(index - 1);      // 해당 Index Node를 조회
        SinglyNode removeNode = findNode.nextNode; // 찾은 Index Node의 다음 노드 조회

        findNode.nextNode = removeNode.nextNode;   // 해당 Index Node의 nextNode를 제거 할 Node의 nextNode로 할당
        removeNode.nextNode = null;                // 제거 할 Node의 nextNode를 null로 할당

        // 총 길이 1 감소
        this.count = this.count - 1;

        return removeNode;
    }


    public void print() {
        // 현재 노드를 기준으로
        SinglyNode tmpNode = this.head;

        // null이 아니라면
        while (tmpNode != null) {
            Object data = tmpNode.data;
            System.out.println(data);
            tmpNode = tmpNode.nextNode;
        }
    }


    public void getHead() {
        Object data = this.head.data;
        System.out.println("Head : " + data);
    }

    public void getTail() {
        Object data = this.tail.data;
        System.out.println("Tail : " + data);
    }

    public void getCount() {
        int count = this.count;
        System.out.println("Count : " + count);
    }
}

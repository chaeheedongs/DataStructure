package c_linked_list;

public class DoublyLinkedList {

    private DoublyNode head; // 맨 앞 노드
    private DoublyNode tail; // 맨 뒤 노드
    private int count;       // List 총 길이

    protected class DoublyNode {

        Object data;         // 데이터
        DoublyNode nextNode; // 다음 노드
        DoublyNode prevNode; // 이전 노드

        // Constructor
        public DoublyNode(Object data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }

    // Constructor
    public DoublyLinkedList(Object data) {

        // 새로운 노드를 생성
        DoublyNode newNode = new DoublyNode(data);

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
     *         "nextNode": null,
     *         "prevNode": null
     *     }
     * </pre>
     */
    public void append(Object value) {

        // 새로운 노드를 생성
        DoublyNode newNode = new DoublyNode(value);

        // 데이터가 없다면 Head와 Tail에 새로운 노드를 연결
        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        }
        // 데이터가 있다면
        // Tail의 다음 노드와 현재 Tail에 새로운 노드를 연결 후
        // Tail을 새 노드의 이전 노드로 할당 후
        // Tail에 새 노드를 저장
        else {
            this.tail.nextNode = newNode;
            newNode.prevNode = this.tail;
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
    public DoublyNode removeLast() {

        // 데이터가 없다면 null 리턴
        if(this.count == 0){
            return null;
        }

        // 데이터가 1개 이상 이라면
        DoublyNode currentNode = this.tail;

        // Tail은 Tail 이전 노드를 저장 후
        // Tail의 다음 노드를 제거 후
        // 현재 노드에서 이전 노드를 제거
        this.tail = this.tail.prevNode;
        this.tail.nextNode = null;
        currentNode.prevNode = null;

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
        DoublyNode newNode = new DoublyNode(data);

        // 데이터가 없다면 Head와 Tail에 새로운 노드를 연결
        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        }
        // 데이터가 있다면
        // 새 노드의 다음 노드를 Head로 할당 후
        // Head의 이전 노드를 새 노드로 할당 후
        // Head에 새 노드를 저장
        else {
            newNode.nextNode = this.head;
            this.head.prevNode = newNode;
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
    public DoublyNode removeFirst() {

        // 데이터가 없다면 null 리턴
        if(this.count == 0) {
            return null;
        }

        // 데이터가 있다면
        DoublyNode currentNode = this.head;

        // Head는 Head 이후 노드를 저장 후
        // Head의 이전 노드를 제거 후
        // 현재 노드에서 다음 노드를 제거
        this.head = this.head.nextNode;
        this.head.prevNode = null;
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
     * Get <p>
     * - LinkedList의 인덱스 조회 <p>
     * - O(n)
     * -----------------------------------------------
     */
    public DoublyNode get(int index) {

        // 찾으려는 index가 0보다 작거나 count보다 크거나 같으면 null을 반환
        if (index < 0 || index >= this.count) {
            return null;
        }

        // swapNode 생성
        DoublyNode swapNode = null;

        // Index가 count의 반 값 보다 크면 swapNode를 Head로 저장
        // Index가 count의 반 값 보다 작으면 swapNode를 Tail로 저장 후
        // 다음 또는 이전 노드 검색
        if (index < this.count / 2) {
            swapNode = this.head;
            for (int i = 0; i < index; i++) {
                swapNode = swapNode.nextNode;
            }
        }
        else  {
            swapNode = this.tail;
            for (int i = this.count - 1; i > index; i--) {
                swapNode = swapNode.prevNode;
            }
        }

        // 찾은 노드를 리턴
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
        DoublyNode tmp = get(index);

        // 찾은 Node의 데이터가 존재한다면 데이터를 수정
        if (tmp != null) {
            tmp.data = data;
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
        if(index < 0 || index > this.count) {
            return false;
        }

        // 데이터가 없다면 맨 앞에 데이터를 추가
        if (index == 0) {
            prepend(data);
            return true;
        }

        // Node의 개수와 index가 일치한다면 맨 뒤에 데이터를 추가
        if (index == this.count) {
            append(data);
            return true;
        }

        // 중간에 있다면
        DoublyNode newNode = new DoublyNode(data);  // 새로운 Node를 생성
        DoublyNode prev = get(index - 1);           // 해당 Index Node를 조회 후 prev로 저장
        DoublyNode next = prev.nextNode;            // prev의 다음 노드를 next로 저장

        newNode.prevNode = prev;    // 새 노드의 이전 노드에 prev 할당
        newNode.nextNode = next;    // 새 노드의 이후 노드에 next 할당
        prev.nextNode = newNode;    // prev의 다음 노드를 새 노드로 할당
        next.prevNode = newNode;    // next의 이전 노드를 새 노드로 할당

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
    public DoublyNode remove(int index) {

        // 찾으려는 index가 0보다 작거나 count보다 크거나 같으면 null을 반환
        if(index < 0 || index >= this.count) {
            return null;
        }

        // index가 0이면 첫 번째 제거
        if(index == 0) {
            return removeFirst();
        }

        // Node의 개수와 index가 일치한다면 맨 뒤에 데이터를 제거
        if(index == this.count - 1) {
            return removeLast();
        }

        DoublyNode findNode = get(index - 1);      // 해당 Index Node를 조회

        findNode.nextNode.prevNode = findNode.prevNode; // 조회한 노드의 다음 노드의 이전 노드를 조회한 노드의 이전 노드로 할당
        findNode.prevNode.nextNode = findNode.nextNode; // 조회한 노드의 이전 노드의 다음 노드를 조회한 노드의 다음 노드로 할당
        findNode.nextNode = null; // 조회한 노드의 다음 노드를 제거
        findNode.prevNode = null; // 조회한 노드의 이전 노드를 제거

        // 총 길이 1 감소
        this.count = this.count - 1;

        return findNode;
    }


    public void print() {
        // 현재 노드를 기준으로
        DoublyLinkedList.DoublyNode tmpNode = this.head;

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

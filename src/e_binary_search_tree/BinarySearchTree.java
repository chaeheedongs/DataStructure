package e_binary_search_tree;

public class BinarySearchTree {

    private BinaryNode root;


    class BinaryNode {

        int data;
        BinaryNode left;
        BinaryNode right;

        // Constructor
        public BinaryNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public boolean insert(int data) {

        // 새로운 노드를 생성
        BinaryNode newNode = new BinaryNode(data);

        if (this.root == null) {
            this.root = newNode;
            return true;
        }

        // root 노드를 임시 노드로 지정
        BinaryNode tmp = this.root;

        while (true) {

            // 새 노드의 데이터가 임시노드의 데이터와 같으면 false 리턴(중복)
            if (newNode.data == tmp.data) {
                return false;
            }

            // 새 노드의 데이터가 임시노드의 데이터보다 작으면
            if (newNode.data < tmp.data) {

                // 임시노드의 왼쪽이 비었으면 할당
                if (tmp.left == null) {
                    tmp.left = newNode;
                    return true;
                }

                // 임시노드가 비어있지 않으면 왼쪽의 임시노드 재할당
                tmp = tmp.left;
            }
            // 새 노드의 데이터가 임시노드의 데이터보다 크면
            else {
                // 임시노드의 오른쪽이 비었으면 할당
                if (tmp.right == null) {
                    tmp.right = newNode;
                    return true;
                }

                // 임시노드가 비어있지 않으면 오른쪽의 임시노드 재할당
                tmp = tmp.right;
            }

        }
    }


    // TODO <----
    public boolean remove(int data) {
        return true;
    }


    public boolean contains(int data) {

        // root 노드가 없으면 false 리턴
        if (this.root == null) {
            return false;
        }

        // root 노드를 임시 노드로 지정
        BinaryNode tmp = this.root;

        // 임시노드가 비어있지 않으면
        while (tmp != null) {

            // 조회하는 값이 임시노드의 데이터보다 작으면
            if (data < tmp.data) {
                // 왼쪽으로 뎁스 이동
                tmp = tmp.left;
            }
            // 조회하는 값이 임시노드의 데이터보다 크면
            else if (data > tmp.data) {
                // 오른쪽으로 뎁스 이동
                tmp = tmp.right;
            }
            // 조회하는 값이 임시노드의 데이터와 같으면
            else {
                return true;
            }

        }

        return false;
    }
}

package i_recursion;

public class RecursionCompleteBinarySearchTree {

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


    public boolean recursionContains(int data) {
        return recursionContains(this.root, data);
    }

    public void recursionInsert(int data) {

        // root 노드가 없으면 root 노드 등록
        if (this.root == null) {
            root = new BinaryNode(data);
        }
        // root 노드가 있으면 진행
        else {
            recursionInsert(this.root, data);
        }
    }

    public void recursionDelete(int data) {
        recursionDelete(this.root, data);
    }


    private boolean recursionContains(BinaryNode currentNode, int data) {

        // root 노드가 없으면 false 리턴
        if (currentNode == null) {
            return false;
        }

        // root 노드의 데이터와 찾는 데이터가 같으면 true 리턴
        if (currentNode.data == data) {
            return true;
        }

        // 찾는 데이터가 현재 node의 데이터보다 작으면
        if (data < currentNode.data) {
            return recursionContains(currentNode.left, data);
        }
        // 찯는 데이터가 현재 node의 데이터보다 크면
        else if (data > currentNode.data) {
            return recursionContains(currentNode.right, data);
        }
        else {
            return false;
        }
    }


    private BinaryNode recursionInsert(BinaryNode currentNode, int data) {

        // 현재 node가 없으면 새 노드 를 생성 후 할당
        if(currentNode == null) {
            return new BinaryNode(data);
        }

        // 추가 하려는 데이터가 현재 node의 데이터보다 작으면
        if (data < currentNode.data) {
            currentNode.left = recursionInsert(currentNode.left, data);
        }
        // 추가 하려는 데이터가 현재 node의 데이터보다 크면
        else if (data > currentNode.data) {
            currentNode.right = recursionInsert(currentNode.right, data);
        }

        return currentNode;
    }

    private BinaryNode recursionDelete(BinaryNode currentNode, int data) {

        // 현재 node가 비어 있다면 null 반환
        if(currentNode == null) return null;

        // 삭제 하려는 데이터가 현재 node의 데이터보다 작으면
        if (data < currentNode.data) {
            currentNode.left = recursionDelete(currentNode.left, data);
        }
        // 삭제 하려는 데이터가 현재 node의 데이터보다 크면
        else if (data > currentNode.data) {
            currentNode.right = recursionDelete(currentNode.right, data);
        }
        // 삭제 하려는 데이터와 현재 node의 데이터가 같으면
        else {
            // 조건1 : 왼쪽 자식 노드가 null 인지 확인
            boolean isLeftNull = currentNode.left == null;
            // 조건2 : 오른쪽 자식 노드가 null 인지 확인
            boolean isRightNull = currentNode.right == null;

            if (isLeftNull && isRightNull) {
                return null;
            }
            else if (isLeftNull) {
                currentNode = currentNode.right;
            }
            else if (isRightNull) {
                currentNode = currentNode.left;
            }
            // 위 조건과 다르다면 교체
            else {
                int minData = minData(currentNode.right);
                currentNode.data = minData;
                currentNode.right = recursionDelete(currentNode.right, minData);
            }
        }

        return currentNode;
    }

    public int minData(BinaryNode currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }

    public BinaryNode getRoot() {
        return this.root;
    }
}

# Recursion

<br/><br/><br/>



## Index

* [Recursion 이란?](#Recursion-이란?)
* [Factorial 구현](#Factorial-구현)
* [Recursion Complete Binary Search Tree 구현](#Recursion-Complete-Binary-Search-Tree-구현)

---

<br/><br/><br/>



## Recursion 이란?

Recursion 즉 재귀란 자기 자신을 다시 참조하는 것 이다.  
대표적인 예로 수학의 펙토리얼 또는 하노이의 탑 문제가 있다.  
그리고 Binary Search Tree를 Recursion 으로 만들 수 있다.  

Recursion은 반복문(for, while) 문을 대체 할 수 있으며,  
주의해야 할 점은 끝나는 점이 있어야 한다.  

끝나는 점이 없으면 계속 자기 자신을 호출하기 때문에  
무조건 스텍 오버 플로우가 발생한다.

[Factorial 코드 확인하기](https://github.com/chaeheedongs/DataStructure/blob/main/src/i_recursion/RecursionTest.java)  
[Recursion Complete BST 코드 확인하기](https://github.com/chaeheedongs/DataStructure/blob/main/src/i_recursion/RecursionCompleteBinarySearchTree.java)

<br/><br/><br/>



## Factorial 구현
* n이 양수 기준으로 n = n * (n - 1)! 공식을 가진다.
* 값이 1이면 탈출 조건을 타고 종료한다.
* ~~~java
    public static int factorial(int value) {
        // 매개변수 값이 1이면 1을 리턴한다
        if(value == 1) return 1;

        /**
         * 매개변수 * 재귀(매개변수 - 1)
         * 3 * Recursion(3 - 1) -> 3
         * 2 * Recursion(2 - 1) -> 2
         * 1 -> 1
         * => 3 * 2 * 1 = 6
         */
        return value * factorial(value - 1);
    }
  ~~~
  
<br/><br/><br/>



## Recursion Complete Binary Search Tree 구현

> Complete Binary Search Tree 를 Recursion 으로 구현 한다.

<br/>

### Contains
* Complete Binary Search Tree에 값이 있는지 Recursion 구조로 조회 한다.
* ~~~java
    private boolean contains(Node currentNode, int data) {

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
  ~~~

<br/>

### Insert
* Complete Binary Search Tree에 Recursion 구조로 데이터를 추가 한다.
* ~~~java
    private Node insert(Node currentNode, int data) {

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
  ~~~

<br/>

### Remove
* Complete Binary Search Tree에 Recursion 구조로 데이터를 삭제 한다.
* ~~~java
    private BinaryNode recursionRemove(BinaryNode currentNode, int data) {
  
        // 현재 node가 비어 있다면 null 반환
        if(currentNode == null) return null;

        // 삭제 하려는 데이터가 현재 node의 데이터보다 작으면
        if (data < currentNode.data) {
            currentNode.left = recursionRemove(currentNode.left, data);
        }
        // 삭제 하려는 데이터가 현재 node의 데이터보다 크면
        else if (data > currentNode.data) {
            currentNode.right = recursionRemove(currentNode.right, data);
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
                currentNode.right = recursionRemove(currentNode.right, minData);
            }
        }

        return currentNode;
    }
  ~~~

<br/><br/><br/>

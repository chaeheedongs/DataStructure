
# Sort

<br/><br/><br/>



## Index

* [Sort 란?](#Sort-란?)
* [Sort 종류](#Sort-종류)
* [Sort 시간복잡도](#Sort-시간복잡도)
* [Bubble Sort](#Bubble-Sort)
* [Selection Sort](#Selection-Sort)
* [Insertion Sort](#Insertion-Sort)

---

<br/><br/><br/>



## Sort 란?
데이터의 특정 조건을 기준으로 정렬을 하는 것 이다.  
정렬 조건으로 오름차순과 내림차순이 있다.  

사전을 보면 a ~ z 순서로 나열이 되어 있는 것을 확인할 수 있다.  
앞에서 끝으로 가는 순서를 오름차순(Ascending) 이라고 하며,  
끝에서 앞으로 가는 순서를 내림차순(Descending) 이라고 한다.

<br/><br/><br/>



## Sort 종류
* [Bubble Sort (버블 정렬)](#Bubble-Sort)
* [Selection Sort (선택 정렬)](#Selection-Sort)
* [Insertion Sort (삽입 정렬)](#Insertion-Sort)

<br/><br/><br/>



## Sort 시간복잡도

![](img/sort-big-notation.png)

<br/><br/><br/>



## Bubble Sort

![](img/sort-bubble-img.png)

[코드 확인하기](https://github.com/chaeheedongs/DataStructure/blob/main/src/j_sort/BubbleSort.java)

* 버블 정렬 이라고 부른다.
* Sort 알고리즘 중에서 제일 느리고 좋지 않다.
* Big O -> O(n²)
* ~~~java
    // 내림차순
    if (ASC.equals(cending)) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {

                // index 계산
                int current = j;
                int next = j + 1;

                // 조건부 스왑
                if (array[current] > array[next]) {
                    int swap = array[current];
                    array[current] = array[next];
                    array[next] = swap;
                }
            }
        }
    }
    // 오름차순
    else if (DESC.equals(cending)) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {

                // index 계산
                int current = j;
                int next = j + 1;
                
                // 조건부 스왑
                if (array[current] < array[next]) {
                    int swap = array[current];
                    array[current] = array[next];
                    array[next] = swap;
                }
            }
        }
    }
  ~~~

<br/><br/><br/>



## Selection Sort

![](img/sort-selection-img.png)

[코드 확인하기](https://github.com/chaeheedongs/DataStructure/blob/main/src/j_sort/SelectionSort.java)

* 선택 정렬 이라고 부른다.
* Sort 알고리즘 중에서 버블 정렬 다음으로 빠르지만 느리고 좋지 않다.
* Big O -> O(n²)
* ~~~java
    // 내림차순
    if (ASC.equals(cending)) {
        for (int i = 1; i < array.length; i++) {

            int currentIndex = i - 1;
            int minIndex = currentIndex;

            for (int j = 0; j < array.length - i; j++) {

                // index 계산
                int current = j;
                int next = j + 1;

                // 값 비교
                if (array[current] > array[next]) {
                    minIndex = next;
                }
            }

            // 조건부 스왑
            if (currentIndex != minIndex) {
                int swap = array[currentIndex];
                array[currentIndex] = array[minIndex];
                array[minIndex] = swap;
            }
        }
    }
    // 오름차순
    else if (DESC.equals(cending)) {
        for (int i = 1; i < array.length; i++) {

            int currentIndex = i - 1;
            int maxIndex = currentIndex;

            for (int j = 0; j < array.length - i; j++) {

                // index 계산
                int current = j;
                int next = j + 1;

                // 값 비교
                if (array[current] < array[next]) {
                    maxIndex = next;
                }
            }

            // 조건부 스왑
            if (currentIndex != maxIndex) {
                int swap = array[currentIndex];
                array[currentIndex] = array[maxIndex];
                array[maxIndex] = swap;
            }
        }
    }
  ~~~

<br/><br/><br/>



## Insertion Sort

![](img/sort-insertion-img.png)

[코드 확인하기](https://github.com/chaeheedongs/DataStructure/blob/main/src/j_sort/InsertionSort.java)

* 삽입 정렬 이라고 부른다.
* Sort 알고리즘 중에서 버블, 선택 정렬 다음으로 빠르지만 느리고 좋지 않다.
* Big O -> O(n)
* ~~~java
    // 내림차순
    if (ASC.equals(cending)) {
        for (int i = 1; i < array.length; i++) {
            // index 계산
            int current = i;
            int prev = i - 1;
            
            boolean flag = true;

            // 조건부 스왑
            while (array[current] < array[prev] && flag) {
                
                int swap = array[prev];
                array[prev] = array[current];
                array[current] = swap;

                if (prev == 0) {
                    flag = false;
                }
                else {
                    prev = prev - 1;
                    current = current - 1;
                }
            }
        }
    }
    // 오름차순
    else if (DESC.equals(cending)) {
        for (int i = 1; i < array.length; i++) {
            // index 계산
            int current = i;
            int prev = i - 1;

            boolean flag = true;

            // 조건부 스왑
            while (array[current] > array[prev] && flag) {

                int swap = array[prev];
                array[prev] = array[current];
                array[current] = swap;

                if (prev == 0) {
                    flag = false;
                }
                else {
                    prev = prev - 1;
                    current = current - 1;
                }
            }
        }
    }
  ~~~
<br/><br/><br/>

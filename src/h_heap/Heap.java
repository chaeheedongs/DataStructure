package h_heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    // Constructor
    public Heap() {
        this.heap = new ArrayList<>();
    }

    // heap Getter
    public List<Integer> getHeap() {
        return new ArrayList<>(this.heap);
    }

    // heap 출력
    public void print() {
        for (Integer data : this.heap) {
            System.out.printf("%d  ", data);
        }
        System.out.println();
    }

    // 데이터 추가
    public void insert(int data) {

        this.heap.add(data);                     // 맨 마지막 인덱스에 데이터를 추가
        int currentIndex = this.heap.size() - 1; // 추가한 데이터의 인덱스 조회

        while (true) {

            // 조건 1 : 현재 인덱스가 0보다 큰가
            boolean isIndexGreaterThanZero = currentIndex > 0;
            // 조건 2 : 현재 인덱스의 데이터가 부모 데이터보다 큰가
            boolean isIndexGreaterThanParentIndex = this.heap.get(currentIndex) > this.heap.get(parent(currentIndex));

            // 조건이 맞다면
            if (isIndexGreaterThanZero && isIndexGreaterThanParentIndex) {
                swap(currentIndex, parent(currentIndex)); // 현재 인덱스와 부모 인덱스를 교환
                currentIndex = parent(currentIndex);      // 현재 인덱스를 부모 인덱스로 할당
            }
            // 조건이 틀리면
            else {
                return;
            }
        }
    }

    // 데이터 제거
    public Integer remove() {
        // 힙 크기가 0이면 0 반환
        if (this.heap.size() == 0){
            return 0;
        }

        // 힙 크기가 1개밖에 없다면 그냥 제거
        if(this.heap.size() == 1) {
            return this.heap.remove(0);
        }

        // 루트 노드 조회
        int maxValue = this.heap.get(0);
        // 트리의 오른쪽 마지막 리프 노드를 루트 노드로 할당
        this.heap.set(0, this.heap.remove(this.heap.size() - 1));
        // 힙 재 계산
        reCalculate(0);

        // 초기 루트 노드 값 반환
        return maxValue;
    }

    // 왼쪽 노드 인덱스 조회
    private int left(int index) {
        return (2 * index) + 1; // 공식
    }

    // 오른쪽 노드 인덱스 조회
    private int right(int index) {
        return (2 * index) + 2; // 공식
    }

    // 부모 인덱스 조회
    private int parent(int index) {
        return (index - 1) / 2; // 공식
    }

    // 위치 변경 (스왑)
    private void swap(int index1, int index2) {
        int tmp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, tmp);
    }

    // 트리 노드 재 계산
    private void reCalculate(int index) {
        int tmpIndex = index;

        while (true) {

            int leftIndex = left(index);
            int rightIndex = right(index);

            // 조건 1 : 왼쪽 또는 오른쪽 노드 인덱스가 힙 사이즈보다 큰가
            boolean isLeftIndexGreaterThanHeapSize = leftIndex < this.heap.size();
            boolean isRightIndexGreaterThanHeapSize = rightIndex < this.heap.size();

            // 조건 1의 내용중 왼쪽 또는 오른쪽 노드가 없다면 종료
            if (!(isLeftIndexGreaterThanHeapSize && isRightIndexGreaterThanHeapSize)) {
                return;
            }

            // 조건 2 : 왼쪽 또는 오른쪽 노드 값이 tmp 값보다 큰가
            boolean isLeftGreaterThanTmp = this.heap.get(leftIndex) > this.heap.get(tmpIndex);
            boolean isRightGreaterThanTmp = this.heap.get(rightIndex) > this.heap.get(tmpIndex);

            // 조건이 맞다면
            if (isLeftIndexGreaterThanHeapSize && isLeftGreaterThanTmp) {
                tmpIndex = leftIndex;
            }

            if (isRightIndexGreaterThanHeapSize && isRightGreaterThanTmp) {
                tmpIndex = rightIndex;
            }

            if (tmpIndex != index) {
                swap(index, tmpIndex);
                index = tmpIndex;
            }
            // 조건이 틀리면
            else {
                return;
            }
        }
    }
}

package j_sort;

import java.util.Arrays;

public class MergeSort {

    static String ASC = "ASC";
    static String DESC = "DESC";

    public static void main(String[] args) {

        int[] ascendingArr = {6, 5, 4, 3, 2, 1};
        int[] descendingArr = {1, 2, 3, 4, 5, 6};

        System.out.println();
        System.out.println(" Ascending Merge Sort");
        System.out.println("[6, 5, 4, 3, 2, 1]");
        System.out.println("----------------------");
        print(mergeSort(ascendingArr, ASC));

        System.out.println();
        System.out.println("Descending Merge Sort");
        System.out.println("[1, 2, 3, 4, 5, 6]");
        System.out.println("----------------------");
        print(mergeSort(descendingArr, DESC));
    }

    public static int[] mergeSort(int[] array, String cending) {

        int arrLength = array.length;

        if(arrLength == 1)
            return array;

        // 중간 인덱스 조회
        int middleIndex = arrLength / 2;

        // 왼, 오른 쪽 배열 생성
        int[] leftArr = Arrays.copyOfRange(array, 0, middleIndex);
        int[] rightArr = Arrays.copyOfRange(array, middleIndex, arrLength);

        // 재귀로 왼, 오른 쪽 배열의 길이가 1이 되도록 쪼개기
        int[] left = mergeSort(leftArr, cending);
        int[] right = mergeSort(rightArr, cending);

        // 쪼갠 배열 합치기
        return merge(left, right, cending);
    }

    public static int[] merge(int[] left, int[] right, String cending) {

        // 응답 할 변수 및 인덱스 초기화
        int[] mergeArr = new int[left.length + right.length];
        int index = 0;
        int leftIdx = 0;
        int rightIdx = 0;

        // 내림차순
        if (ASC.equals(cending)) {
            // 왼 쪽과 오른 쪽의 길이가 인덱스보다 크면
            while (leftIdx < left.length && rightIdx < right.length) {
                // 오른 쪽이 크면
                if (left[leftIdx] < right[rightIdx]) {
                    mergeArr[index] = left[leftIdx];
                    leftIdx = leftIdx + 1;
                }
                // 왼 쪽이 크면
                else {
                    mergeArr[index] = right[rightIdx];
                    rightIdx = rightIdx + 1;
                }
                index = index + 1;
            }
        }
        // 오름차순
        else if (DESC.equals(cending)) {
            while (leftIdx < left.length && rightIdx < right.length) {
                // 왼 쪽이 크면
                if (left[leftIdx] > right[rightIdx]) {
                    mergeArr[index] = left[leftIdx];
                    leftIdx = leftIdx + 1;
                }
                // 오른 쪽이 크면
                else {
                    mergeArr[index] = right[rightIdx];
                    rightIdx = rightIdx + 1;
                }
                index = index + 1;
            }
        }

        // 남은 배열 정리
        while (leftIdx < left.length) {
            mergeArr[index] = left[leftIdx];
            index = index + 1;
            leftIdx = leftIdx + 1;
        }

        while (rightIdx < right.length) {
            mergeArr[index] = right[rightIdx];
            index = index + 1;
            rightIdx = rightIdx + 1;
        }

        return mergeArr;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}

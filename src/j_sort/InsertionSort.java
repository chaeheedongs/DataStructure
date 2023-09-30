package j_sort;

public class InsertionSort {

    static String ASC = "ASC";
    static String DESC = "DESC";

    public static void main(String[] args) {

        int[] ascendingArr = {6, 5, 4, 3, 2, 1};
        int[] descendingArr = {1, 2, 3, 4, 5, 6};

        System.out.println();
        System.out.println(" Ascending Bubble Sort");
        System.out.println("[6, 5, 4, 3, 2, 1]");
        System.out.println("----------------------");
        insertionSort(ascendingArr, ASC);

        System.out.println();
        System.out.println("Descending Bubble Sort");
        System.out.println("[1, 2, 3, 4, 5, 6]");
        System.out.println("----------------------");
        insertionSort(descendingArr, DESC);
    }

    public static void insertionSort(int[] array, String cending) {

        // 내림차순
        if (ASC.equals(cending)) {
            for (int i = 1; i < array.length; i++) {
                // index 계산
                int current = i;
                int prev = i - 1;

                boolean flag = true;

                // 조건부 스왑
                while (array[current] < array[prev] && flag) {
                    System.out.printf("current : %d, next : %d \n", current, prev);

                    int swap = array[prev];
                    array[prev] = array[current];
                    array[current] = swap;

                    if (prev == 0) {
                        print(array);
                        System.out.println("---------------------");

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
                    System.out.printf("current : %d, next : %d \n", current, prev);

                    int swap = array[prev];
                    array[prev] = array[current];
                    array[current] = swap;

                    if (prev == 0) {
                        print(array);
                        System.out.println("---------------------");

                        flag = false;
                    }
                    else {
                        prev = prev - 1;
                        current = current - 1;
                    }

                }
            }
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}

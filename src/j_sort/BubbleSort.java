package j_sort;

public class BubbleSort {

    static String ASC = "ASC";
    static String DESC = "DESC";

    public static void main(String[] args) {

        int[] ascendingArr = {6, 5, 4, 3, 2, 1};
        int[] descendingArr = {1, 2, 3, 4, 5, 6};

        System.out.println();
        System.out.println(" Ascending Bubble Sort");
        System.out.println("[6, 5, 4, 3, 2, 1]");
        System.out.println("----------------------");
        bubbleSort(ascendingArr, ASC);

        System.out.println();
        System.out.println("Descending Bubble Sort");
        System.out.println("[1, 2, 3, 4, 5, 6]");
        System.out.println("----------------------");
        bubbleSort(descendingArr, DESC);
    }

    public static void bubbleSort(int[] array, String cending) {

        // 내림차순
        if (ASC.equals(cending)) {
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length - i; j++) {

                    // index 계산
                    int current = j;
                    int next = j + 1;
                    System.out.printf("current : %d, next : %d \n", current, next);

                    // 조건부 스왑
                    if (array[current] > array[next]) {
                        int swap = array[current];
                        array[current] = array[next];
                        array[next] = swap;
                    }
                }

                print(array);
                System.out.println("---------------------");
            }
        }
        // 오름차순
        else if (DESC.equals(cending)) {
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < array.length - i; j++) {

                    // index 계산
                    int current = j;
                    int next = j + 1;
                    System.out.printf("current : %d, next : %d \n", current, next);

                    // 조건부 스왑
                    if (array[current] < array[next]) {
                        int swap = array[current];
                        array[current] = array[next];
                        array[next] = swap;
                    }
                }

                print(array);
                System.out.println("---------------------");
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


//// 내림차순
//if (ASC.equals(cending)) {
//    for (int i = 1; i < array.length; i++) {
//        for (int j = array.length - 1; j >= i; j--) {
//
//            // index 계산
//            int current = j;
//            int prev = j - 1;
//            System.out.printf("current : %d, next : %d \n", current, prev);
//
//            // 변경
//            if (array[current] < array[prev]) {
//                int swap = array[prev];
//                array[prev] = array[current];
//                array[current] = swap;
//            }
//        }
//
//        print(array);
//        System.out.println("---------------------");
//    }
//}
//// 오름차순
//else if (DESC.equals(cending)) {
//    for (int i = 1; i < array.length; i++) {
//        for (int j = 0; j < array.length - i; j++) {
//
//            // index 계산
//            int current = j;
//            int next = j + 1;
//            System.out.printf("current : %d, next : %d \n", current, next);
//
//            // 변경
//            if (array[current] < array[next]) {
//                int swap = array[current];
//                array[current] = array[next];
//                array[next] = swap;
//            }
//        }
//
//        print(array);
//        System.out.println("---------------------");
//    }
//}
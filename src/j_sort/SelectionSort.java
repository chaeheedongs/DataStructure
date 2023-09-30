package j_sort;

public class SelectionSort {

    static String ASC = "ASC";
    static String DESC = "DESC";

    public static void main(String[] args) {

        int[] ascendingArr = {6, 5, 4, 3, 2, 1};
        int[] descendingArr = {1, 2, 3, 4, 5, 6};

        System.out.println();
        System.out.println(" Ascending Selection Sort");
        System.out.println("[6, 5, 4, 3, 2, 1]");
        System.out.println("----------------------");
        selectionSort(ascendingArr, ASC);

        System.out.println();
        System.out.println("Descending Selection Sort");
        System.out.println("[1, 2, 3, 4, 5, 6]");
        System.out.println("----------------------");
        selectionSort(descendingArr, DESC);
    }

    public static void selectionSort(int[] array, String cending) {

        // 내림차순
        if (ASC.equals(cending)) {
            for (int i = 1; i < array.length; i++) {

                int currentIndex = i - 1;
                int minIndex = currentIndex;

                for (int j = 0; j < array.length - i; j++) {

                    // index 계산
                    int current = j;
                    int next = j + 1;
                    System.out.printf("current : %d, next : %d \n", current, next);

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

                print(array);
                System.out.println("---------------------");
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
                    System.out.printf("current : %d, next : %d \n", current, next);

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
//
//        int currentIndex = array.length - i;
//        int minIndex = currentIndex;
//
//        for (int j = array.length - 1; j >= i; j--) {
//
//            // index 계산
//            int current = j;
//            int prev = j - 1;
//            System.out.printf("current : %d, next : %d \n", current, prev);
//
//            // 값 비교
//            if(array[current] < array[prev]) {
//                minIndex = prev;
//            }
//        }
//
//        // 변경
//        if (currentIndex != minIndex) {
//            int swap = array[currentIndex];
//            array[currentIndex] = array[minIndex];
//            array[minIndex] = swap;
//        }
//
//        print(array);
//        System.out.println("---------------------");
//    }
//}
//// 오름차순
//else if (DESC.equals(cending)) {
//    for (int i = 1; i < array.length; i++) {
//
//        int currentIndex = i - 1;
//        int maxIndex = currentIndex;
//
//        for (int j = 0; j < array.length - i; j++) {
//
//            // index 계산
//            int current = j;
//            int next = j + 1;
//            System.out.printf("current : %d, next : %d \n", current, next);
//
//            // 값 비교
//            if (array[current] < array[next]) {
//                maxIndex = next;
//            }
//        }
//
//        // 변경
//        if (currentIndex != maxIndex) {
//            int swap = array[currentIndex];
//            array[currentIndex] = array[maxIndex];
//            array[maxIndex] = swap;
//        }
//
//        print(array);
//        System.out.println("---------------------");
//    }
//}
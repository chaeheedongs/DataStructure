package a_big_o;

public class C_quadratic {

    public static void main(String[] args) {

        /**
         * BigO - O(n²) <p>
         * 처음부터 끝까지 루프를 n 제곱 으로 돈다. <p> <p>
         */
        int n = 5;
        int funcResult = func(n);
        System.out.println("funcResult count = " + funcResult);
        System.out.println();

        /**
         * BigO - O(n * n) => O(n²) <p>
         * - n * n 의 경우 n을 두번 곱한 n²이 된다. <p>
         */
    }

    // O(n * n) => O(n²)
    public static int func(int n) {

        System.out.println();
        System.out.println("This is O(n²)");
        System.out.println("-------------");

        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.println("i, j = " + j + ", " + j);
                count = count + 1;
            }

        }

        return count;
    }
}

package a_big_o;

public class B_linear {

    public static void main(String[] args) {

        /**
         * BigO - O(n) <p>
         * - 처음부터 끝까지 루프를 돈다. <p>
         */
        int n = 5;
        int funcResult = func(n);
        System.out.println("funcResult count = " + funcResult);
        System.out.println();

        /**
         * BigO - O(n + n) => O(2n) => O(n) <p>
         * - 처음부터 끝까지 루프를 두번 돈다. <p>
         * - n + n 의 경우 n을 두번 더한 2n이 된다. <p>
         * - Big O 표기법에서 상수는 의미가 없어 제외 한다. <p>
         */
        int funcResult2 = func2(n);
        System.out.println("funcResult2 count = " + funcResult2);
        System.out.println();
    }

    public static int func(int n) {

        System.out.println();
        System.out.println("This is O(n)");
        System.out.println("------------");

        int count = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            count = count + 1;
        }

        return count;
    }

    // O(n + n) => O(2n) => O(n)
    public static int func2(int n) {

        System.out.println("This is O(2n)");
        System.out.println("-------------");

        int count = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            count = count + 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            count = count + 1;
        }

        return count;
    }
}

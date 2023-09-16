package i_recursion;

public class RecursionTest {

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

    public static void recursionMethodThree() {
        System.out.println("Recursion Method Three");
    }

    public static void recursionMethodTwo() {
        recursionMethodThree();
        System.out.println("Recursion Method Two");
    }

    public static void recursionMethodOne() {
        recursionMethodTwo();
        System.out.println("Recursion Method One");
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Call Recursion Process");
        System.out.println("-----------------------");
        recursionMethodOne();


        System.out.println();
        System.out.println("Call Factorial");
        System.out.println("-----------------------");
        int factorial = factorial(3);
        System.out.println("factorial = " + factorial);
    }
}

package a_big_o;

public class A_constant {

    public static void main(String[] args) {

        /**
         * BigO - O(1) <p>
         * - 한번에 끝난다. <p>
         */
        int result = func(1);
        System.out.println("result = " + result);
    }

    public static int func(int n) {

        System.out.println("This is O(1)");
        System.out.println("------------");

        return n + n;

//        아래 모든 것은 O(n) 이다.
//        return n + n + n;
//        return n + n + n + n;
//        return n + n + n + n + ... + n;
    }
}

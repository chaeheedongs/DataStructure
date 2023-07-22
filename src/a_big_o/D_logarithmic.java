package a_big_o;

public class D_logarithmic {

    public static void main(String[] args) {

        /**
         * BigO - O(log₂(n)) <p>
         * 로그 방정식을 활용해 찾는다.
         * 전체 데이터 길이를 반씩 쪼개어 찾는다.
         */
        int n = 16;
        int funcResult = func(n);
        System.out.println("funcResult count = " + funcResult);
        System.out.println();


    }

    // O(log₂(n))
    public static int func(int n) {

        System.out.println();
        System.out.println("This is O(log n)");
        System.out.println("----------------");

        int count = 0;

        while(n > 1){
            count = count + 1;
            n = n / 2;
            System.out.println("n = " + n + ", count = " + count);
        }

        return count;
    }
}

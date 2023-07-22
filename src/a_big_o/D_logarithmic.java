package a_big_o;

public class D_logarithmic {

    public static void main(String[] args) {

        /**
         * BigO - O(log n) <p>
         *  <p>
         */
        int n = 16;
        int funcResult = func(n);
        System.out.println("funcResult count = " + funcResult);
        System.out.println();


    }

    // O(log n)
    public static int func(int n) {

        System.out.println();
        System.out.println("This is O(log n)");
        System.out.println("----------------");

        int count = 0;

        while(n > 1){ //log n+1
            count = count + 1;
            n = n / 2; //log n
            System.out.println("n = " + n + ", count = " + count);
        }

        return count;
    }
}

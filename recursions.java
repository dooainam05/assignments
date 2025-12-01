// package recursion;

public class recursions {


    public static int maxarr(int[] arr, int max, int i) {

        if (i == arr.length) {
            return max;
        }
        if (arr[i] > max) {
            max = arr[i];
        }
        return maxarr(arr, max, i + 1);

    }

    public static int gcd(int n, int m) {

        if (m == 0) { // base case
            return n;
        }

        return gcd(m, n % m); // recursive call
    }

    public static int fabseries(int a, int b, int n) {

        if (n == 0) {
            return 0;
        }
        int c = a + b;
        System.out.print(c);
        return fabseries(b, c, n - 1);

    }

    public static void main(String[] args) {

        int a = 0;
        int b = 1;
        int n = 9;
        System.out.print(a);
        System.out.print(b);
        fabseries(a, b, n - 2);
        System.out.println();
        System.out.println(gcd(27, 36));
      
        int[] arr = { 2, 4, 6, 7 };
        System.out.println(maxarr(arr, 2, 0));

    }
}

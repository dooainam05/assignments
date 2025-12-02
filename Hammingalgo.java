// package assignment2java;

import java.util.Scanner;

public class Hammingalgo {

    // Generate Hamming(7,4)
    static int[] generate(int d[]) {
        int h[] = new int[7];

        h[2] = d[0]; // D1
        h[4] = d[1]; // D2
        h[5] = d[2]; // D3
        h[6] = d[3]; // D4

        // Parity bits
        h[0] = h[2] ^ h[4] ^ h[6];
        h[1] = h[2] ^ h[5] ^ h[6];
        h[3] = h[4] ^ h[5] ^ h[6];

        return h;
    }

                                                // to detect & correct error
    static void detectAndCorrect(int h[]) {
        int p1 = h[0] ^ h[2] ^ h[4] ^ h[6];
        int p2 = h[1] ^ h[2] ^ h[5] ^ h[6];
        int p4 = h[3] ^ h[4] ^ h[5] ^ h[6];

        int error = p1 * 1 + p2 * 2 + p4 * 4;

        if (error == 0) {
            System.out.println("\nNo error detected!");
        } else {
            System.out.println("\nError at bit position: " + error);
            h[error - 1] ^= 1;   // bit flip
            System.out.println("Corrected Code: ");
            for (int x : h) System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d[] = new int[4];
        System.out.println("Enter 4 data bits (0/1):");
        for(int i=0; i<4; i++) d[i] = sc.nextInt();

        int h[] = generate(d);

        System.out.print("\nGenerated Hamming Code : ");
        for(int x : h) System.out.print(x+" ");

        System.out.println("\n\nEnter received 7-bit code:");
        int rec[] = new int[7];
        for(int i=0; i<7; i++) rec[i] = sc.nextInt();

        detectAndCorrect(rec);

        sc.close();
    }
}

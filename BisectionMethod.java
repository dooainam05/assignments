// package assignment2java;

import java.util.Scanner;

public class BisectionMethod {

    
    static double f(double x) {
        return (x * x * x) - x - 2;   //koi bhi equation
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a, b, c = 0, fa, fb, fc;
        double tolerance = 0.0001;

        System.out.print("Enter value of a: ");
        a = sc.nextDouble();

        System.out.print("Enter value of b: ");
        b = sc.nextDouble();

        fa = f(a);
        fb = f(b);
sc.close();
       
        if (fa * fb > 0) {    //interval check honge if they are valid or not
            System.out.println("Invalid interval! f(a) and f(b) must have opposite signs.");
            return;
        }

       
        while (Math.abs(b - a) > tolerance) {
            c = (a + b) / 2;
            fc = f(c);

            if (fc == 0.0) {
                break;                      //root found
            }

            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }

        System.out.println("Approximate Root = " + c);

        
    }
}
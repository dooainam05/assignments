// package assignment2java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.URL;

import java.util.Scanner;
// ASSIGNMENT 5
public class download {

    public static void main(String[] args) throws Exception {
       
Scanner scanner = new Scanner(System.in);
System.out.println("enter url of website");
String url = scanner.nextLine();

URL website = new URL(url);


    BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
    PrintWriter out = new PrintWriter("page.txt");

String line;
while ((line = in.readLine())!= null) {
    out.println(line); 
    
}
scanner.close();
in.close();
out.close();


    }
    
}

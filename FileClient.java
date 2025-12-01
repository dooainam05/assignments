// package assignment2java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// ASSIGNMENT 4
public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9092);
        System.out.println("Connected to server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scan = new Scanner(System.in);

        // ---- show file list ----
        System.out.println("\nFiles on server:");
        String line;
        while (!(line = in.readLine()).equals("END_OF_LIST"))
            System.out.println("  " + line);
        System.out.println();

        // ---- ask user ----
        while (true) {
            System.out.print("Enter: get file <name>  (or quit): ");
            String input = scan.nextLine();                              //agar input quit hia tau break
            if (input.equalsIgnoreCase("quit")) break;

            out.println(input);

            if (input.startsWith("get file ")) {          
                System.out.println("\n--- file content ---");     
                while (!(line = in.readLine()).equals("END_OF_FILE")) { 
                    if (line.startsWith("ERROR:")) {
                        System.out.println(line);              
                        break;
                    }
                    System.out.println(line);
                }
                System.out.println("--- end ---\n");
            }
        }

        socket.close();
        scan.close();
    }
}

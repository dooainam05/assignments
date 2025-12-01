// package assignment2java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// ASSIGNMENT 4
public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9092);
        System.out.println("Server running , waiting for client...");

        Socket client = server.accept();
        System.out.println("Client connected!");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        // ---- send file list ----
        File dir = new File("."); //files ya folder ki sari files display 
        for (String f : dir.list()) out.println(f);
        out.println("END_OF_LIST");//list ka end identify

        // ---- wait for command ----
        String cmd;
        while ((cmd = in.readLine()) != null) {
            if (cmd.startsWith("get file ")) {
                String name = cmd.substring(9);
                File file = new File(name);
                if (file.isFile()) {
                    BufferedReader fileIn = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = fileIn.readLine()) != null) out.println(line);
                    fileIn.close();
                    out.println("END_OF_FILE");
                } else {
                    out.println("ERROR: no such file");
                }
            }
        }

        client.close();
        server.close();
    }
}

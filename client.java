import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// ASSIGNMENT NUMBER 2
public class client {

    public static void main(String[] args) {
try{        
//socket banao to connect to server
System.out.println("hi im client");
Socket socket = new Socket("localhost",9090);
System.out.println("connected to server");//server ka ip address or apna port num se connect hoa

//streams banao
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
Scanner scanner = new Scanner(System.in);

String SM = in.readLine();
System.out.println("server: "+SM);


System.out.println("enter your msg to server");
String CM= scanner.nextLine();
out.println(CM);

SM = in.readLine();
System.out.println("server: "+SM);


in.close();
out.close();
scanner.close();
socket.close();

System.out.println("server disconnected");


    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}
    
}



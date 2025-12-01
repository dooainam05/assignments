import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// ASSIGNMENT NUMBER 2
public class server {
    
    public static void main(String[] args) {
try{        
ServerSocket ss = new ServerSocket(9090);//server ban gaya now waiting for client
System.out.println("server running waiting for the client ");

//client ko accept 
Socket clienSocket = ss.accept();//ss ne accepts req from client
System.out.println("client connected");//client connected


BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
    


PrintWriter out = new PrintWriter(clienSocket.getOutputStream(),true);


out.println("hello from server");//msg sent to client

String CM = in.readLine();//msg recieved from client
System.out.println("Client:"+CM);


out.println("your msg "+CM+" is recieved");


in.close();
out.close();
ss.close();
clienSocket.close();



    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}
}
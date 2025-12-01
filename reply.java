import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// ASSIGNMENT NUMBER 3
public class reply {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",9090);
            System.out.println("Connected to server");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            Scanner scanner = new Scanner(System.in);
String SM,CM;
            while(true){

                SM=in.readLine(); 
                if(SM.equalsIgnoreCase("bye")){
                   
                    System.out.println("server: "+ SM);
                    System.out.println("server disconnected");
                    break;
                }
                else{
                    System.out.println("server: "+SM);
                    
                    CM=scanner.nextLine();
                    out.println(CM);
                    if(CM.equalsIgnoreCase("bye")){
                    System.out.println("you ended the chat");
                    break;
                    }
                }
            }in.close();
            out.close();
            scanner.close();
            s.close();


        } catch (Exception e) {
            
        }

    }
}

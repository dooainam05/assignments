import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// ASSIGNMENT NUMBER 3
public class chat {

public static void main(String[] args) {
    
    try{
        ServerSocket ss = new ServerSocket(9090);
        System.out.println("server is running");

        Socket clienSocket = ss.accept();
        System.out.println("client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
        PrintWriter out =new PrintWriter(clienSocket.getOutputStream(),true);
        Scanner scanner = new Scanner(System.in);
        String SM,CM;

        out.println("hi from server");
        // String line;
        while(true){
            CM = in.readLine();
            if(CM.equalsIgnoreCase("Bye")){ //bye //BYE
                break;
            }

            System.out.println("client: "+CM); 
            SM = scanner.nextLine();
            out.println(SM);

            if(SM.equalsIgnoreCase("bye")){
               break;
            }    
            }
            in.close();
        out.close();
        ss.close();
 scanner.close();
        }
       

    catch(IOException e){
        System.out.println(e.getMessage());
    }
}

}

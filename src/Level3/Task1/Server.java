/*
 *		 Level-3 	Task-1: Implement a Chat Application

Develop a chat application using Java and networking libraries like Socket or Java NIO.
This task will enhance their knowledge of network programming, client-server architecture, and message exchange.
 */
package Level3.Task1;

import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) throws IOException{
        ServerSocket serversocket = new ServerSocket(9999);
        System.out.println("Server Waiting...");
        Socket socket = serversocket.accept();
        System.out.println("Connection Successful!");

        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        DataInputStream din = new DataInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);
        new Thread(()->{
            while (true) {
                try {
                    String msg;
                    System.out.print("You: ");
                    msg = sc.next();
                    dout.writeUTF(msg);
                    dout.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }                    
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    String msg = din.readUTF();
                    System.out.println("\n Message From Client : "+msg);
                    System.out.print("You: ");
                } catch (IOException e) {
                    e.printStackTrace();
                }                    
            }
        }).start();


    }

    
}
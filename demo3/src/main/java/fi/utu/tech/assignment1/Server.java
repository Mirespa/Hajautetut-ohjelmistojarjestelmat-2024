package fi.utu.tech.assignment1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // TODO: Palvelinohjelma
        ServerSocket serverSocket = new ServerSocket(2000);
        
        Socket commSocket = serverSocket.accept();

        System.out.println("Connected");
    }
    
}

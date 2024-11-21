package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // TODO: Kopioi edellisen tehtäväsi vastaus tähän pohjalle
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("Running");
        
        while (true) {
            Socket commSocket = serverSocket.accept();
            System.out.println("Connected");
            
            ClientHandler ch = new ClientHandler();
            new Thread(() -> {
                try {
                    ch.run(commSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

package fi.utu.tech.assignment2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException{
        // TODO: Kopioi edellisen tehtäväsi vastaus tähän pohjalle
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("Running");
        
        Socket commSocket = serverSocket.accept();
        System.out.println("Connected");

        var iStream = commSocket.getInputStream();
        byte[] received = iStream.readAllBytes();

        String reveivedMesssage = new String(received, "utf-8");
        System.out.println("Message: " + reveivedMesssage);

        commSocket.close();
        serverSocket.close();
    }

}

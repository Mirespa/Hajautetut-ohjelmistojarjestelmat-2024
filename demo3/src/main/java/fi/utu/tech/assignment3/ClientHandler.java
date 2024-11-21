package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {

    // TODO: Toteuta asiakaspalvelija tänne
    public void run(Socket commSocket) throws IOException {
        var iStream = commSocket.getInputStream();
        byte[] received = iStream.readAllBytes();

        String reveivedMesssage = new String(received, "utf-8");
        System.out.println("Message: " + reveivedMesssage);

        commSocket.close();
    }

    
}

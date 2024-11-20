package fi.utu.tech.assignment2;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        // TODO: Kopioi edellisen tehtäväsi vastaus tähän pohjalle
        Socket s = new Socket("localhost", 2000);
        System.out.println("Connected to server");

        var oStream =s.getOutputStream();
        String stringToSend = "Heippa";

        byte[] bytesToSend = stringToSend.getBytes("utf-8");
        System.out.println("Sending");
        oStream.write(bytesToSend);
        System.out.println("Sent");

        s.close();
    }

}

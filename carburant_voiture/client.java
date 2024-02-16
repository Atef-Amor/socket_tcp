import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); 

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            voiture vcl = new voiture("pick up", "Renault Alaskan"); 
            vcl.setCarburant(90); 

            output.writeObject(vcl);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

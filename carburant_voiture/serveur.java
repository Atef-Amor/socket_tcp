import java.io.*;
import java.net.*;

public class serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); 

            Socket socket = serverSocket.accept();

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            voiture voitureCl = (voiture) input.readObject();

            int carburant = voitureCl.getCarburant();
            System.out.println("La Quantité de carburant est : " + carburant);

            socket.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

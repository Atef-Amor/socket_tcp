import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);

        // spécification du port par l'utilisateur
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            // controler le format de l'input
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try {
            // Création d'un objet ServerSocket pour écouter les connexions entrantes sur le port spécifié.
            ServerSocket serverSocket = new ServerSocket(port);

            // accepter la connexion entrante
            Socket socket = serverSocket.accept();

            // Initialiser les flux de sortie et d'entrée.
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // lire le message envoyé par le client
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);

            // afficher l'@ ip et le num de port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() +
                    ":" + socket.getPort());

            // envoyer une validation au client
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            //gestion des exceptions
            System.err.println("Erreur : " + e);
        }
    }
}

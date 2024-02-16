import java.io.*;
import java.net.*;
import java.util.Scanner;

class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);

        // spécification du nom du serveur
        System.out.print("Nom du serveur : ");
        host = keyb.next();

        // spécification du port du serveur
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            // controler le format de l'input 
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }

        try {
            // résoudre le nom d'hôte en adresse IP
            InetAddress adr = InetAddress.getByName(host);

            // établir une connexion avec le serveur à l'adresse et au port spécifiés
            Socket socket = new Socket(adr, port);

            // initialiser les flux de sortie et d'entrée
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // envoyer un message au serveur
            output.writeObject(new String("ma première socket"));

            // lire la réponse du serveur
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            // gestion des exceptions
            System.err.println("Erreur : " + e);
        }
    }
}

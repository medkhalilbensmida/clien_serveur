

import java.io.*;
import java.net.*;

public class client_TCP {
    public static void main(String[] args) {
        Socket clientSocket = null;

        try {
            // Adresse IP et port du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 50000;

            // Création d'un socket client TCP
            clientSocket = new Socket(serverAddress, serverPort);

            // Créer des flux de lecture et d'écriture pour communiquer avec le serveur
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            // Message à envoyer au serveur
            String message = "Bonjour serveur TCP";

            // Envoyer le message au serveur
            outToServer.writeBytes(message + '\n');

            // Lire la réponse du serveur
            String serverResponse = inFromServer.readLine();

            // Afficher la réponse du serveur
            System.out.println("Réponse du serveur: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
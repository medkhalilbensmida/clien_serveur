import java.io.*;
import java.net.*;

public class serveur_TCP {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // Création d'un socket serveur TCP sur le port 6789
            serverSocket = new ServerSocket(50000);

            while (true) {
                // Attendre une connexion entrante
                Socket clientSocket = serverSocket.accept();

                // Créer des flux de lecture et d'écriture pour communiquer avec le client
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

                // Lire une ligne envoyée par le client
                String clientMessage = inFromClient.readLine();

                // Afficher le message reçu du client
                System.out.println("Message reçu du client: " + clientMessage);

                // Envoyer une réponse au client
                String capitalizedMessage = "BONJOUR"+"\n";
                outToClient.writeBytes(capitalizedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

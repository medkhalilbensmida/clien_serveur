import java.net.*;

public class serveur_UDP {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;

        try {
            // Création d'un socket UDP sur le port 9876
            serverSocket = new DatagramSocket(50000);

            byte[] receiveData = new byte[1024];

            while (true) {
                // Création du paquet de réception
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Réception des données
                serverSocket.receive(receivePacket);

                // Conversion des données reçues en chaîne de caractères
                String sentence = new String(receivePacket.getData());

                // Affichage des données reçues
                System.out.println("message reçu: " + sentence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
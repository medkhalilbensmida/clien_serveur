import java.net.*;

public class client_UDP {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;

        try {
            // Création d'un socket UDP
            clientSocket = new DatagramSocket();

            // Adresse IP et port du serveur
            InetAddress IPAddress = InetAddress.getByName("localhost");
            int port = 50000;

            // Message à envoyer
            String message = "Bonjour serveur UDP je suis le client";

            // Conversion du message en tableau d'octets
            byte[] sendData = message.getBytes();

            // Création du paquet à envoyer
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            // Envoi du paquet
            clientSocket.send(sendPacket);

            System.out.println("Message envoyé: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
} 

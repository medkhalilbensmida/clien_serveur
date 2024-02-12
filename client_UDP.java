import java.net.*;

public class client_UDP {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;

        try {
            clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");
            int port = 50000;

            String message = "Bonjour serveur UDP je suis le client";

            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

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



import java.io.*;
import java.net.*;

public class client_TCP {
    public static void main(String[] args) {
        Socket clientSocket = null;

        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 50000;

            clientSocket = new Socket(serverAddress, serverPort);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            String message = "Bonjour serveur TCP";

            outToServer.writeBytes(message + '\n');

            String serverResponse = inFromServer.readLine();

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
import java.io.*;
import java.net.*;

public class serveur_TCP {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(50000);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage = inFromClient.readLine();

                System.out.println("Message reçu du client: " + clientMessage);

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
     ServerSocket serverSocket=null;
     Socket clientSocket = null;
     int port = 8080;
        try {
               serverSocket = new ServerSocket(port);
            Client client = new Client();
            client.start();
            clientSocket = serverSocket.accept();
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
         clientSocket.close();
         serverSocket.close();
        }

    }
}

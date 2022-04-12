import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

 class Client extends Thread
 {
    @Override
    public void run ()
         {
        int port = 8080;
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost", port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("New client\n");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

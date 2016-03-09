package src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{

   Server(int port) {
      try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Listening on 127.0.0.1:"+port);
            int clientCount = -1;
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientCount++;
                System.out.println("Client "+clientCount+" connected.");
                new Thread(new Connection(clientSocket,clientCount)).start();
            }
        } catch (IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
   }


}

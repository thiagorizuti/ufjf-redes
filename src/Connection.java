package src;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.System.in;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection implements Runnable {
   Socket clientSocket;
   int clientId;

   Connection(Socket clientSocket, int clientId) {
      this.clientSocket = clientSocket;
      this.clientId = clientId;
   }

   @Override
   public void run()  {
      try {
        DataInputStream clientIn = new DataInputStream (clientSocket.getInputStream());
        PrintStream clientOut = new PrintStream(clientSocket.getOutputStream());
        byte[] buffer = new byte[4096];
        String message;

        clientOut.println("Hello client!\nEnter your message.\nEnter '\\close' to close connection.");

        while((message = new String(buffer, 0, clientIn.read(buffer))) != null) {
            if(message.contains("\\close")){
                clientIn.close();
                clientOut.close();
                clientSocket.close();
            }
            System.out.print("Client " + clientId + " says: " + message);
            clientOut.print("Received: " + message);
        }
      }

      catch (IOException e) {
         if(e instanceof SocketException){
             System.out.println("Client "+clientId+" disconnected.");
         }else{
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
         }
      }

   }
}

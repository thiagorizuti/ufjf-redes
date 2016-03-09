package src;

import java.util.Scanner;
import static javafx.scene.input.KeyCode.I;

public class Main {

    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter port to start server");
        int port = keyboard.nextInt();
        new Server(port);
   }
}

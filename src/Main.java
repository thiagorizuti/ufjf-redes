/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;
import static javafx.scene.input.KeyCode.I;

/**
 *
 * @author thiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter port to start server");
        int port = keyboard.nextInt();
        new Server(port);
   }
}

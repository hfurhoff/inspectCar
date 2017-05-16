/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;


/**
 * This class is responsible for connecting to the external system that is the 
 * printer and handle commands to that system.
 * @author Coyote
 */
public class Printer {

    /**
     * Prints the specified text.
     * @param textToPrint Text to be printed.
     */
    public void print(String textToPrint) {
        System.out.println("\n" + textToPrint + "\n");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.Receipt;

/**
 * This class is responsible for connecting to the external system that is the 
 * printer and handle commands to that system.
 * @author Coyote
 */
public class Printer {

    /**
     * Gets the text to print from the receipt and sends a print command to the printer with that text.
     * @param receiptForCurrentTransaction The receipt to be printed.
     */
    public void printReceipt(Receipt receiptForCurrentTransaction) {
        print(receiptForCurrentTransaction.getTextToPrint());
    }

    /**
     * Prints the specified text.
     * @param textToPrint Text to be printed.
     */
    private void print(String textToPrint) {
    }


    
}

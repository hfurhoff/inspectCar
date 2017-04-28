/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.Receipt;

/**
 *
 * @author Coyote
 */
public class Printer {

    public void printReceipt(Receipt receiptForCurrentTransaction) {
        print(receiptForCurrentTransaction.getTextToPrint());
    }

    private void print(String textToPrint) {
    }


    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.Payment;

/**
 * The receipt proves a payment.
 * @author Coyote
 */
public class Receipt {

    private final int cost;
    private final Date paymentDate;
    private final boolean paymentApproved;
    private final String textToPrint;
    
    /**
     * Creates a receipt for a payment 
     * @param payment The payment that the receipt will prove;
     */
    public Receipt(Payment payment) {
        this.cost = payment.getCost();
        this.paymentDate = payment.getPaymentDate();
        this.paymentApproved = payment.getApproved();
        
        if(paymentApproved){
            textToPrint = ("RECEIPT:\nThe payment off " + cost + " SEK was approved on " + paymentDate.toString());
        }
        else{
            textToPrint = ("RECEIPT:\nThe payment off " + cost + " SEK was not approved on " + paymentDate.toString());
        }
    }
    
    /**
     * Returns a printable version of the receipt.
     * @return A string that tells information about the receipt that can be printed.
     */
    public String getTextToPrint(){
        return textToPrint;
    }
}

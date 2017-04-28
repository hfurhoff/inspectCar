/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Coyote
 */
public class Receipt {

    private final String textToPrint;
    
    public Receipt(int cost, Date paymentDate, boolean paymentApproved) {
        if(paymentApproved){
            textToPrint = ("The payment off " + cost + " SEK was approved on " + paymentDate.toString());
        }
        else{
            textToPrint = ("The payment off " + cost + " SEK was not approved on " + paymentDate.toString());
        }
    }
    
    public String getTextToPrint(){
        return textToPrint;
    }
}

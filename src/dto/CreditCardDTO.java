/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


/**
 * This class is just a data transfer object for the information associated with a specified creditcard.
 * @author Coyote
 */
public class CreditCardDTO {
    private final int pin;
    private final String number;
    private final String holder;
    private final Date expiryDate;
    private final int cvc;
    
    /**
     * Creates a data transfer object for a credit card
     * @param pin Pin number
     * @param number Creditcardnumber
     * @param holder Creditcardholder
     * @param expiryMonth Month of expiry
     * @param expiryYear Year of expiry 
     * @param cvc Cvc number for the creditcard
     */
    public CreditCardDTO(int pin, String number, String holder, int expiryMonth, int expiryYear, int cvc){
        this.pin = pin;
        this.number = number;
        this.holder = holder;
        this.expiryDate = new Date(expiryMonth, expiryYear);
        this.cvc = cvc;
    }
}

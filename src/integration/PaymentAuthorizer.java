/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.CreditCardDTO;

/**
 *
 * @author Coyote
 */
public class PaymentAuthorizer {

    public PaymentAuthorizer(){
        
    }

    public boolean authorizePayment(CreditCardDTO creditCard, int cost) {
        return true;
    }
}

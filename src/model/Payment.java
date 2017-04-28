/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.CreditCardDTO;
import dto.Date;
import dto.Receipt;
import integration.PaymentAuthorizer;
import integration.Printer;

/**
 * The class responsible to make the payment
 * @author Coyote
 */
public class Payment {
    
    private boolean paymentApproved;
    
    /**
     * 
     * @param creditCard
     * @param cost
     * @param bank
     * @param printer 
     */
    public Payment(CreditCardDTO creditCard, int cost, PaymentAuthorizer bank, Printer printer) {
        Date paymentDate = createPaymentDate();
        sendPaymentRequestToAuthorizer(bank, creditCard, cost);
        Receipt receiptForCurrentTransaction = createReceipt(cost, paymentDate);
        printer.printReceipt(receiptForCurrentTransaction);
    }
    
    /**
     * 
     * @return 
     */
    private Date createPaymentDate() {
        Date paymentDate = new Date();
        return paymentDate;
    }

    /**
     * 
     * @param bank
     * @param creditCard
     * @param cost 
     */
    private void sendPaymentRequestToAuthorizer(PaymentAuthorizer bank, CreditCardDTO creditCard, int cost) {
        this.paymentApproved = bank.authorizePayment(creditCard, cost);
    }

    /**
     * 
     * @param cost
     * @param paymentDate
     * @return 
     */
    private Receipt createReceipt(int cost, Date paymentDate) {
        Receipt receiptForCurrentTransaction = new Receipt(cost, paymentDate, paymentApproved);
        return receiptForCurrentTransaction;
    }

    /**
     * 
     * @return 
     */
    public boolean getApproved() {
        return paymentApproved;
    }
    
}

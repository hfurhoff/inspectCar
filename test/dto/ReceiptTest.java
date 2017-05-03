/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import integration.PaymentAuthorizer;
import integration.Printer;
import model.Payment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Coyote
 */
public class ReceiptTest {
    
    CreditCardDTO creditcard;
    PaymentAuthorizer bank;
    Printer printer;
    
    public ReceiptTest() {
    }
    
    @Before
    public void setUp() {
        final int pin = 1;
        final String number = "";
        final String holder = "";
        final int expiryMonth = 1;
        final int expiryYear = 1;
        final int cvc = 1;
        creditcard = new CreditCardDTO(pin, number, holder, expiryMonth, expiryYear, cvc);
        bank = new PaymentAuthorizer();
        printer = new Printer();
    }
    
    @After
    public void tearDown() {
        creditcard = null;
        bank = null;
        printer = null;
    }

    /**
     * Test of getTextToPrint method, of class Receipt.
     */
    @Test
    public void testGetTextToPrintWhenCostIsLow() {
        int cost = 1;
        Payment payment = new Payment(creditcard, cost, bank, printer);
        Receipt instance = new Receipt(payment);
        String expResult = "RECEIPT:\nThe payment off 1 SEK was approved on 4/5/2017";
        String result = instance.getTextToPrint();
        assertEquals("Wrong receipt was made.", expResult, result);
    }
    
    /**
     * Test of getTextToPrint method, of class Receipt.
     */
    @Test
    public void testGetTextToPrintWhenCostIsHigh() {
        int cost = 50000;
        Payment payment = new Payment(creditcard, cost, bank, printer);
        Receipt instance = new Receipt(payment);
        String expResult = "RECEIPT:\nThe payment off 50000 SEK was not approved on 4/5/2017";
        String result = instance.getTextToPrint();
        assertEquals("Wrong receipt was made.", expResult, result);
    }
    
}

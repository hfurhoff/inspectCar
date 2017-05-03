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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Coyote
 */
public class ReceiptTest {
    
    public ReceiptTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTextToPrint method, of class Receipt.
     */
    @Test
    public void testGetTextToPrintWhenCostIsLow() {
        CreditCardDTO creditcard = new CreditCardDTO(1, "", "", 1, 1, 1);
        int cost = 1;
        PaymentAuthorizer bank = new PaymentAuthorizer();
        Printer printer = new Printer();
        Payment payment = new Payment(creditcard, cost, bank, printer);
        Receipt instance = new Receipt(payment);
        String expResult = "The payment off 1 SEK was approved on 4/5/2017";
        String result = instance.getTextToPrint();
        assertEquals("Wrong receipt was made.", expResult, result);
    }
    
    /**
     * Test of getTextToPrint method, of class Receipt.
     */
    @Test
    public void testGetTextToPrintWhenCostIsHigh() {
        CreditCardDTO creditcard = new CreditCardDTO(1, "", "", 1, 1, 1);
        int cost = 50000;
        PaymentAuthorizer bank = new PaymentAuthorizer();
        Printer printer = new Printer();
        Payment payment = new Payment(creditcard, cost, bank, printer);
        Receipt instance = new Receipt(payment);
        String expResult = "The payment off 50000 SEK was not approved on 4/5/2017";
        String result = instance.getTextToPrint();
        assertEquals("Wrong receipt was made.", expResult, result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.CreditCardDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PaymentAuthorizer
 * @author Coyote
 */
public class PaymentAuthorizerTest {
    
    CreditCardDTO creditCard;
    PaymentAuthorizer instance;
    
    public PaymentAuthorizerTest() {
    }
    
    @Before
    public void setUp() {
        creditCard = null;
        instance = new PaymentAuthorizer();
    }
    
    @After
    public void tearDown() {
        creditCard = null;
        instance = null;
    }

    /**
     * Test of authorizePayment method, of class PaymentAuthorizer.
     */
    @Test
    public void testAuthorizePaymentWithLowCost() {
        int cost = 0;
        boolean expResult = true;
        boolean result = instance.authorizePayment(creditCard, cost);
        assertEquals("Did not approve payment even though there was enough money on the account.", expResult, result);
    }
    
    /**
     * Test of authorizePayment method, of class PaymentAuthorizer.
     */
    @Test
    public void testAuthorizePaymentWithHighCost() {
        int cost = 50000;
        boolean expResult = false;
        boolean result = instance.authorizePayment(creditCard, cost);
        assertEquals("Approved payment even though there was not enough money on the account.", expResult, result);
    }
    
}

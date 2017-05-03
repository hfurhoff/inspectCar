/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.CreditCardDTO;
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
public class PaymentAuthorizerTest {
    
    public PaymentAuthorizerTest() {
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
     * Test of authorizePayment method, of class PaymentAuthorizer.
     */
    @Test
    public void testAuthorizePaymentWithLowCost() {
        CreditCardDTO creditCard = null;
        int cost = 0;
        PaymentAuthorizer instance = new PaymentAuthorizer();
        boolean expResult = true;
        boolean result = instance.authorizePayment(creditCard, cost);
        assertEquals("Did not approve payment even though there was enough money on the account.", expResult, result);
    }
    
    /**
     * Test of authorizePayment method, of class PaymentAuthorizer.
     */
    @Test
    public void testAuthorizePaymentWithHighCost() {
        CreditCardDTO creditCard = null;
        int cost = 50000;
        PaymentAuthorizer instance = new PaymentAuthorizer();
        boolean expResult = false;
        boolean result = instance.authorizePayment(creditCard, cost);
        assertEquals("Approved payment even though there was not enough money on the account.", expResult, result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class remark.
 * @author Coyote
 */
public class RemarkTest {
    
    public RemarkTest() {
    }
    
    Remark instance;

    @Before
    public void setUp() {
        instance = new Remark("ABC", true);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of equals method, of class Remark.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNull() {
        Object obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was null.", expResult, result);
    }
    
    /**
     * Test of equals method, of class Remark.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotInstanceOfRemark() {
        String obj = "hejsvejs";
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was string.", expResult, result);
    }
    
    /**
     * Test of equals method, of class Remark.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotSameInstanceOfRemark() {
        Remark obj = new Remark("CBA", false);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal.", expResult, result);
    }

    /**
     * Test of equals method, of class Remark.
     */
    @Test
    public void testEqualsWhenOtherObjectIsSameInstanceOfRemark() {
        Remark obj = new Remark("ABC", true);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal.", expResult, result);
    }
}

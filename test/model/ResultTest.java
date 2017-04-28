/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import externals.SpecifiedInspection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the class Result
 * @author Coyote
 */
public class ResultTest {
    
    public ResultTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testThatResultIsInitializedCorrectly() {
        SpecifiedInspection[] testArray = { new SpecifiedInspection("a", 1), 
                                            new SpecifiedInspection("b", 2), 
                                            new SpecifiedInspection("c", 3), 
                                            new SpecifiedInspection("d", 4)};
        Result instance = new Result(testArray);
        int expectedRes = testArray.length;
        int result = instance.getNumberOfRemarks();
        assertEquals("Result was not initialized correctly", expectedRes, result);
    }
    
}

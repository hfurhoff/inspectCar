/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externals;

import dto.StoredResult;
import dto.SpecifiedInspection;
import dto.Remark;
import dto.VehicleDTO;
import model.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class StoredResult.
 * @author Coyote
 */
public class StoredResultTest {
    
    public StoredResultTest() {
    }
    
    StoredResult instance;
    
    @Before
    public void setUp() {
        VehicleDTO vehicle = new VehicleDTO("123ABC");
        SpecifiedInspection[] specInsp = {new SpecifiedInspection("Brakes", 666)};
        Result result = new Result(specInsp);
        instance = new StoredResult(vehicle, result, specInsp);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of equals method, of class StoredResult.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNull() {
        StoredResult obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was null.", expResult, result);
    }
    
    /**
     * Test of equals method, of class StoredResult.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotInstanceOfStoredResult() {
        String obj = "hejsvejs";
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was string.", expResult, result);
    }
    
    /**
     * Test of equals method, of class StoredResult.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotSameInstanceOfStoredResult() {
        VehicleDTO vehicle = new VehicleDTO("CBA321");
        SpecifiedInspection[] specInsp = {new SpecifiedInspection("Steering", 333), new SpecifiedInspection("Lights", 999)};
        Result resultOfInspection = new Result(specInsp);
        StoredResult obj = new StoredResult(vehicle, resultOfInspection, specInsp);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal.", expResult, result);
    }
    
    /**
     * Test of equals method, of class StoredResult.
     */
    @Test
    public void testEqualsWhenOtherObjectIsSameInstanceOfStoredResult() {
        VehicleDTO vehicle = new VehicleDTO("123ABC");
        SpecifiedInspection[] specInsp = {new SpecifiedInspection("Brakes", 666)};
        Result resultOfInspection = new Result(specInsp);
        Remark remark = new Remark("Passed.", true);
        resultOfInspection.addRemark(remark);
        StoredResult otherInstance = new StoredResult(vehicle, resultOfInspection, specInsp);
        StoredResult obj = new StoredResult(vehicle, resultOfInspection, specInsp);
        boolean expResult = true;
        boolean result = otherInstance.equals(obj);
        assertEquals("Method returned that the objects were not equal.", expResult, result);
    }
    
}

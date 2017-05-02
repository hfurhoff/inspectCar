/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externals;

import dto.VehicleDTO;
import model.Result;

/**
 * The result of an inspection for a specific vehicle.
 * @author Coyote
 */
public class StoredResult {

    private final VehicleDTO vehicle;
    private final Result result;
    private final SpecifiedInspection[] doneInspections;
    
    /**
     * Creates an object to encapsulate the information and outcome of an inspection.
     * @param vehicle The specifik vehicle for which the inspection has been made.
     * @param result The result of the inspection.
     * @param doneInspections Which specified inspections that have been performed.
     */
    public StoredResult(VehicleDTO vehicle, Result result, SpecifiedInspection[] doneInspections) {
        this.vehicle = vehicle;
        this.result = result;
        this.doneInspections = doneInspections;
    }

    public boolean equals(Object obj) {
        boolean theObjectsAreEqual = true;
        theObjectsAreEqual &= (obj instanceof StoredResult);
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        StoredResult otherStoredResult = (StoredResult) obj;
        theObjectsAreEqual &= vehicle.equals(otherStoredResult.getVehicle());
        theObjectsAreEqual &= result.equals(otherStoredResult.getResult());
        theObjectsAreEqual &= doneInspections.equals(otherStoredResult.getDoneInspections());
        return theObjectsAreEqual;
    }

    private VehicleDTO getVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object getResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.SpecifiedInspection;
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

    @Override
    public boolean equals(Object obj) {
        boolean theObjectsAreEqual = true;
        final boolean isStoredResult = obj instanceof StoredResult;
        theObjectsAreEqual &= isStoredResult;
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        if(obj == null){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        StoredResult otherStoredResult = (StoredResult) obj;
        theObjectsAreEqual &= vehicle.equals(otherStoredResult.getVehicle());
        theObjectsAreEqual &= result.equals(otherStoredResult.getResult());
        
        if(doneInspections.length != otherStoredResult.getNumberOfDoneInspections()){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        for(int i = 0; i < doneInspections.length; i++){
            theObjectsAreEqual &= doneInspections[i].equals(otherStoredResult.getDoneInspection(i));
        }
        
        return theObjectsAreEqual;
    }

    private VehicleDTO getVehicle() {
        return vehicle;
    }

    private Object getResult() {
        return result;
    }
    
    private SpecifiedInspection getDoneInspection(int index) {
        return doneInspections[index];
    }

    private int getNumberOfDoneInspections() {
        return doneInspections.length;
    }
}

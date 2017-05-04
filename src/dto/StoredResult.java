/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

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

    /**
     * Compares this object and the parameter object to see if they are equal.
     * @param obj The presumed equal object.
     * @return True if they are equal, false if not equal. 
     */
    @Override
    public boolean equals(Object obj) {
        boolean theObjectsAreEqual = true;
        
        final boolean isStoredResult = obj instanceof StoredResult;
        theObjectsAreEqual &= isStoredResult;
        
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        final boolean otherObjectIsNull = obj == null;
        
        if(otherObjectIsNull){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        StoredResult otherStoredResult = (StoredResult) obj;
        
        final boolean hasTheSameVehicle = vehicle.equals(otherStoredResult.getVehicle());
        theObjectsAreEqual &= hasTheSameVehicle;
        
        final boolean hasTheSameResult = result.equals(otherStoredResult.getResult());
        theObjectsAreEqual &= hasTheSameResult;
        
        final boolean doesNotHaveTheSameNumberOfInspections = doneInspections.length != otherStoredResult.getNumberOfDoneInspections();
        
        if(doesNotHaveTheSameNumberOfInspections){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        for(int i = 0; i < doneInspections.length; i++){
            final boolean sameInspection = doneInspections[i].equals(otherStoredResult.getDoneInspection(i));
            theObjectsAreEqual &= sameInspection;
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

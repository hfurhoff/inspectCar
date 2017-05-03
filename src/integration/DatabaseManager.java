
package integration;

import dto.VehicleDTO;
import externals.SpecifiedInspection;
import externals.StoredResult;
import model.Result;

/**
 * Responsible for making calls to the database.
 * @author Coyote
 */
public class DatabaseManager {
    
    private final SpecifiedInspection[] dummyInspectionsToBeMade;
    private StoredResult storedResults;
    
    /**
     * Creates an instance of a dummy databasemanager.
     */
    public DatabaseManager(){
        dummyInspectionsToBeMade = new SpecifiedInspection[4];
        dummyInspectionsToBeMade[0] = (new SpecifiedInspection("Brakes", 250));
        dummyInspectionsToBeMade[1] = (new SpecifiedInspection("Steering", 200));
        dummyInspectionsToBeMade[2] = (new SpecifiedInspection("Exhaust levels", 300));
        dummyInspectionsToBeMade[3] = (new SpecifiedInspection("Suspension", 150));
    }
    
    /**
     * Imitation of a databasecall to get an array of specified inspections to be performed.
     * @param vehicle The specified vehicle to inspect.
     * @return An array of specified inspections to be made upon the specified vehicle.
     */
    public SpecifiedInspection[] getInspectionsForVehicle(VehicleDTO vehicle){
        return dummyInspectionsToBeMade;
    }

    /**
     * Stores the result of an inspection.
     * @param vehicle The vehicle that was inspected.
     * @param result The result of the inspection.
     * @param doneInspections The inspections that was performed.
     */
    public void setStoredResult(VehicleDTO vehicle, Result result, SpecifiedInspection[] doneInspections) {
        storedResults = new StoredResult(vehicle, result, doneInspections);
    }
}

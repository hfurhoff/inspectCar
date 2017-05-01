
package integration;

import dto.Remark;
import dto.VehicleDTO;
import externals.SpecifiedInspection;
import model.Result;

/**
 * Responsible for making calls to the database.
 * @author Coyote
 */
public class DatabaseManager {
    
    /**
     * Creates an instance of a dummy databasemanager.
     */
    public DatabaseManager(){
    }
    
    /**
     * Imitation of a databasecall to get an array of specified inspections to be performed.
     * @param vehicle The specified vehicle to inspect.
     * @return An array of specified inspections to be made upon the specified vehicle.
     */
    public SpecifiedInspection[] getInspectionsForVehicle(VehicleDTO vehicle){
        SpecifiedInspection[] dummyInspectionsToBeMade = {  (new SpecifiedInspection("Brakes", 250)),
                                                            (new SpecifiedInspection("Steering", 200)),
                                                            (new SpecifiedInspection("Exhaust levels", 300)),
                                                            (new SpecifiedInspection("Suspension", 150))};
        return dummyInspectionsToBeMade;
    }

    /**
     * Stores the result of an inspection.
     * @param vehicle The vehicle that was inspected.
     * @param result The result of the inspection.
     */
    public void storeResult(VehicleDTO vehicle, Result result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

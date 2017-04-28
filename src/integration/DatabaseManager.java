
package integration;

import dto.VehicleDTO;
import externals.SpecifiedInspection;

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


}

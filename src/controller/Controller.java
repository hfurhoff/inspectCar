
package controller;

import dto.VehicleDTO;
import externals.SpecifiedInspection;
import integration.DatabaseManager;
import integration.Garage;
import model.Inspection;

/**
 * 
 * @author Coyote
 */
public class Controller {
    private final Garage garage;
    private final DatabaseManager dbm;
    private Inspection inspection;
    private final String[] states = {   "Inspection has not begun.", 
                                        "Inspection has started.", 
                                        "Door has closed.", 
                                        "Registrationnumber has been entered and cost has been returned.", 
                                        ""};
    private int currentStateIndex;
    
    /**
     *Creates an instance of the object Controller.
     */
    public Controller(){
        this.garage = new Garage();
        this.dbm = new DatabaseManager();
        this.inspection = null;
        this.currentStateIndex = 0;
    }
    
    /**
     * Makes it possible for a new customer to enter the garage.
     */
    public void startNewInspection(){
        garage.nextCustomer();
        this.currentStateIndex = 1;
    }
    
    /**
     * Closes the garage door so an inspection can immense.
     */
    public void closeGarageDoor(){
        garage.closeDoor();
        this.currentStateIndex = 2;
    }
    /**
     * Method to get the cost of inspection for a specific vehicle
     * @param vehicle the vehicle to inspect.
     * @return the cost for inspecting the specified vehicle.
     */
    public int calculateCostForInspectionBasedOnVehicle(VehicleDTO vehicle){
        SpecifiedInspection[] inspectionsToBeMade = dbm.getInspectionsForVehicle(vehicle);
        this.inspection = new Inspection(vehicle, inspectionsToBeMade);
        this.currentStateIndex = 3;
        return this.inspection.getCost();
    }
    
    public String getCurrentState(){
        return states[currentStateIndex];
    }
}

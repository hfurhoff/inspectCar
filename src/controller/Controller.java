
package controller;

import dto.VehicleDTO;
import externals.SpecifiedInspection;
import integration.DatabaseManager;
import integration.Garage;
import model.Inspection;


public class Controller {
    private final Garage garage;
    private final DatabaseManager dbm;
    private Inspection inspection;
    
    public Controller(){
        this.garage = new Garage();
        this.dbm = new DatabaseManager();
        this.inspection = null;
    }
    
    /**
     * Makes it possible for a new customer to enter the garage.
     */
    public void startNewInspection(){
        garage.nextCustomer();
    }
    
    /**
     * Closes the garage door so an inspection can immense.
     */
    public void closeGarageDoor(){
        garage.closeDoor();
    }
    /**
     * Method to get the cost of inspection for a specific vehicle
     * @param vehicle the vehicle to inspect.
     * @return the cost for inspecting the specified vehicle.
     */
    public int calculateCostForInspectionBasedOnVehicle(VehicleDTO vehicle){
        SpecifiedInspection[] inspectionsToBeMade = dbm.getInspectionsForVehicle(vehicle);
        this.inspection = new Inspection(vehicle, inspectionsToBeMade);
        return this.inspection.getCost();
    }
}

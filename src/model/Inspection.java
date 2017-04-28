
package model;

import dto.VehicleDTO;
import externals.SpecifiedInspection;

/**
 * This class handles all things associated with performing the inspection.
 * @author Coyote
 */
public class Inspection {
    private final SpecifiedInspection[] inspectionChecklist;
    private final int cost;
    private Result result;
    private VehicleDTO vehicle;
    
    /**
     * Creates an instance of the object Inspection based on a vehicle and an inspection checklist.
     * @param vehicle The specified vehicle to inspect.
     * @param inspectionChecklist The inspection checklist to go through.
     */
    public Inspection(VehicleDTO vehicle, SpecifiedInspection[] inspectionChecklist){
        this.inspectionChecklist = inspectionChecklist;
        this.cost = calculateCost();
        this.result = new Result(this.inspectionChecklist);
        this.vehicle = vehicle;
    }
    
    /**
     * Returns the cost associated with the inspection.
     * @return Cost for the inspection.
     */
    public int getCost(){
        return cost;
    }
    
    /**
     * Calculates the cost for inspecting a vehicle based on the inspection checklist.
     * @return The total cost of the inspection.
     */
    private int calculateCost(){
        int totalCost = 0;
        for(SpecifiedInspection insp : this.inspectionChecklist){
            totalCost += insp.getCost();
        }
        return totalCost;
    }
    
}

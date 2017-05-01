
package model;

import dto.Remark;
import dto.VehicleDTO;
import externals.SpecifiedInspection;
import integration.DatabaseManager;
import integration.Printer;

/**
 * This class handles all things associated with performing the inspection.
 * @author Coyote
 */
public class Inspection {
    private final SpecifiedInspection[] inspectionChecklist;
    private int nextSpecifiedInspection;
    private final int cost;
    private Result result;
    private final VehicleDTO vehicle;
    
    /**
     * Creates an instance of the object Inspection based on a vehicle and an inspection checklist.
     * @param vehicle The specified vehicle to inspect.
     * @param inspectionChecklist The inspection checklist to go through.
     */
    public Inspection(VehicleDTO vehicle, SpecifiedInspection[] inspectionChecklist){
        this.inspectionChecklist = inspectionChecklist;
        this.nextSpecifiedInspection = 0;
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

    /**
     * This method is a way for the controller to ask if there are more inspections to come.
     * @return A boolean answer to the statement "There are more inspections to be performed".
     */
    public boolean hasMoreInspections() {
        return nextSpecifiedInspection < inspectionChecklist.length;
    }

    /**
     * Provides the next specified inspection to be performed.
     * @return The next inspection to be performed by the inspector.
     */
    public SpecifiedInspection getNextSpecifiedInspection() {
        SpecifiedInspection nextInspectionToBePerformed = inspectionChecklist[nextSpecifiedInspection];
        nextSpecifiedInspection++;
        return nextInspectionToBePerformed;
    }

    /**
     * Updates the result with the remark for the latest performed specified inspection.
     * @param remark The remark for the latest performed specified inspection.
     */
    public void addRemark(Remark remark) {
        result.addRemark(remark);
    }

    /**
     * Ends the inspection, stores and prints the result.
     * @param dbm The databasemanager to be used when storing the results.
     * @param printer The printer to be used when printing the results.
     */
    public void finishedWithInspection(DatabaseManager dbm, Printer printer) {
        dbm.storeResult(vehicle, result, inspectionChecklist);
        String printableVersionOfTheResult = result.getTextToPrint(inspectionChecklist, vehicle);
        printer.print(printableVersionOfTheResult);
    }
    
}

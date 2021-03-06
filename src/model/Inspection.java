
package model;

import dto.Remark;
import dto.VehicleDTO;
import dto.SpecifiedInspection;
import integration.DatabaseManager;
import integration.Printer;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles all things associated with performing the inspection.
 * @author Coyote
 */
public class Inspection {
    private final SpecifiedInspection[] inspectionChecklist;
    private int nextSpecifiedInspection;
    private final int cost;
    private final Result result;
    private final VehicleDTO vehicle;
    private final List<InspectionObserver> observers;
    
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
        this.observers = new ArrayList<>();
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
        final boolean hasMoreInspections = nextSpecifiedInspection < inspectionChecklist.length;
        return hasMoreInspections;
    }

    /**
     * Returns the next specified inspection to be performed or null if there are no more inspections to be made.
     * @return The next inspection to be performed by the inspector or null if there are no more inspections to be made.
     */
    public SpecifiedInspection getNextSpecifiedInspection() {
        final boolean doesNotHaveAnyMoreInspections = ! (this.hasMoreInspections());
        if(doesNotHaveAnyMoreInspections)
            return null;
        
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
        dbm.setStoredResult(vehicle, result, inspectionChecklist);
        String printableVersionOfTheResult = result.getTextToPrint(inspectionChecklist, vehicle);
        printer.print(printableVersionOfTheResult);
        notifyObservers();
    }
    
    /**
     * Adds all observers from a list to its own list.
     * @param observers The list of observers to be added.
     */
    public void addAllObservers(List<InspectionObserver> observers) {
        this.observers.addAll(observers);
    }

    private void notifyObservers() {
        boolean passed = this.result.getFinalResult();
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).newResult(passed);
        }
    }
}

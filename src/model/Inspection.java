
package model;

import dto.VehicleDTO;
import externals.SpecifiedInspection;

public class Inspection {
    private final SpecifiedInspection[] inspectionChecklist;
    private final int cost;
    private Result result;
    
    public Inspection(VehicleDTO vehicle, SpecifiedInspection[] inspectionChecklist){
        this.inspectionChecklist = inspectionChecklist;
        this.cost = calculateCost();
        this.result = new Result(this.inspectionChecklist);
    }
    
    public int getCost(){
        return this.cost;
    }
    
    private int calculateCost(){
        int totalCost = 0;
        for(SpecifiedInspection insp : this.inspectionChecklist){
            totalCost += insp.getCost();
        }
        return totalCost;
    }
    
}

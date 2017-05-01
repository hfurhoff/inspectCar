
package model;

import dto.Remark;
import dto.VehicleDTO;
import externals.SpecifiedInspection;

/**
 * The result of the inspection that will be sent to the database when the inspection is finished.
 * @author Coyote
 */
public class Result {
    
    private Remark[] remarks;
    private int latestPerformedInspection;
    
    /**
     * Creates a result object where the inspector later on can add his or hers remarks for each specified inspection.
     * @param inspectionChecklist The inspection checklist that the inspector will later go through.
     */
    public Result(SpecifiedInspection[] inspectionChecklist) {
        int counter = 0;
        for(SpecifiedInspection inspection : inspectionChecklist){
            counter++;
        }
        this.remarks = new Remark[counter];
        latestPerformedInspection = -1;
    }    

    /**
     * Updates the result with the remark for the latest performed specified inspection.
     * @param remark The remark for the latest performed specified inspection.
     */
    void addRemark(Remark remark) {
        latestPerformedInspection++;
        remarks[latestPerformedInspection] = remark;
    }

    /**
     * Creates a printable version of itself.
     * @param inspectionChecklist The inspections that was made.
     * @param vehicle The vehicle that was inspected.
     * @return 
     */
    String getTextToPrint(SpecifiedInspection[] inspectionChecklist, VehicleDTO vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

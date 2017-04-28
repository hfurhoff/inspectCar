
package model;

import dto.Remark;
import externals.SpecifiedInspection;

/**
 * The result of the inspection that will be sent to the database when the inspection is finished.
 * @author Coyote
 */
public class Result {
    
    private Remark[] remarks;
    
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
    }    
}

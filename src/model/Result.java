
package model;

import dto.Remark;
import externals.SpecifiedInspection;


public class Result {
    
    private Remark[] remarks;
    
    public Result(SpecifiedInspection[] inspectionChecklist) {
        int counter = 0;
        for(SpecifiedInspection inspection : inspectionChecklist){
            counter++;
        }
        this.remarks = new Remark[counter];
    }    
}

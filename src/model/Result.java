
package model;

import dto.Remark;
import dto.VehicleDTO;
import dto.SpecifiedInspection;

/**
 * The result of the inspection that will be sent to the database when the inspection is finished.
 * @author Coyote
 */
public class Result {
    
    private final Remark[] remarks;
    private int indexOfLatestPerformedInspection;
    
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
        indexOfLatestPerformedInspection = -1;
    }    
    
    /**
     * Updates the result with the remark for the latest performed specified inspection.
     * @param remark The remark for the latest performed specified inspection.
     */
    public void addRemark(Remark remark) {
        indexOfLatestPerformedInspection++;
        remarks[indexOfLatestPerformedInspection] = remark;
    }

    /**
     * Creates a printable version of itself.
     * @param inspectionChecklist The inspections that was made.
     * @param vehicle The vehicle that was inspected.
     * @return 
     */
    String getTextToPrint(SpecifiedInspection[] inspectionChecklist, VehicleDTO vehicle) {
        
        String printableResult = ("PRINTED RESULT:\nThe vehicle with registration number " + vehicle.getRegNo() + " was inspected. This is the result. \n");
        for(int i = 0; i < remarks.length; i++){
            printableResult = printableResult.concat(inspectionChecklist[i].getPartToInspect());
            printableResult = printableResult.concat(" was inspected. The vehicle ");
            if(remarks[i].getPassed())
                 printableResult = printableResult.concat("passed. ");
            else
                 printableResult = printableResult.concat("failed. ");
            printableResult = printableResult.concat("\nCOMMENT: " + remarks[i].getRemark() + "\n");
        }
        
        return printableResult;
    }

    /**
     * Returns the number of remarks.
     * @return The number of remarks.
     */
    int getNumberOfRemarks() {
        return remarks.length;
    }
    
    /**
     * Compares this object and the parameter object to see if they are equal.
     * @param obj The presumed equal object.
     * @return True if they are equal, false if not equal. 
     */
    @Override
    public boolean equals(Object obj){
        boolean theObjectsAreEqual = true;
        final boolean isResult = obj instanceof Result;
        theObjectsAreEqual &= isResult;
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        if(obj == null){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        Result otherResult = (Result) obj;
        theObjectsAreEqual &= (this.indexOfLatestPerformedInspection == otherResult.getIndexOfLatestPerformedInspection());
        theObjectsAreEqual &= (this.getNumberOfRemarks() == otherResult.getNumberOfRemarks());
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        for(int i = 0; i < this.getNumberOfRemarks(); i++){
            theObjectsAreEqual &= this.getRemark(i).equals(otherResult.getRemark(i));
        }
        
        return theObjectsAreEqual;
    }

    private int getIndexOfLatestPerformedInspection() {
        return this.indexOfLatestPerformedInspection;
    }

    private Remark getRemark(int index) {
        return remarks[index];
    }
}

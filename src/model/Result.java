
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
        int numberOfInspections = 0;
        for(SpecifiedInspection inspection : inspectionChecklist){
            numberOfInspections++;
        }
        this.remarks = new Remark[numberOfInspections];
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
        String printableResult;
        final String regNumberOfTheVehicle = vehicle.getRegNo(); 
        
        printableResult = ("PRINTED RESULT:\nThe vehicle with registration number " + 
                regNumberOfTheVehicle + " was inspected. This is the result. \n");
        
        for(int indexOfCurrentSpecInsp = 0; indexOfCurrentSpecInsp < remarks.length; indexOfCurrentSpecInsp++){
            final String partToInspect = inspectionChecklist[indexOfCurrentSpecInsp].getPartToInspect();
            printableResult = printableResult.concat(partToInspect + " was inspected. The vehicle ");
            
            final boolean partPassedInspection = remarks[indexOfCurrentSpecInsp].getPassed();
            
            if(partPassedInspection)
                 printableResult = printableResult.concat("passed. ");
            else
                 printableResult = printableResult.concat("failed. ");
            
            final String remarkOnPart = remarks[indexOfCurrentSpecInsp].getRemark();
            printableResult = printableResult.concat("\nCOMMENT: " + remarkOnPart + "\n");
        }
        
        return printableResult;
    }

    /**
     * Returns the number of remarks.
     * @return The number of remarks.
     */
    int getRemarksCapacity() {
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
        
        final boolean otherObjectIsNull = obj == null;
        
        if(otherObjectIsNull){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        Result otherResult = (Result) obj;
        
        final boolean equallyProgressed;
        equallyProgressed = this.indexOfLatestPerformedInspection == otherResult.getIndexOfLatestPerformedInspection();
        theObjectsAreEqual &= equallyProgressed;
        
        final boolean hasTheSameCapacityToHoldRemarks = this.getRemarksCapacity() == otherResult.getRemarksCapacity();
        theObjectsAreEqual &= hasTheSameCapacityToHoldRemarks;
        
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        for(int i = 0; i < this.getRemarksCapacity(); i++){
            final boolean haveAddedTheSameRemark = this.getRemark(i).equals(otherResult.getRemark(i));
            theObjectsAreEqual &= haveAddedTheSameRemark;
        }
        
        return theObjectsAreEqual;
    }

    private int getIndexOfLatestPerformedInspection() {
        return this.indexOfLatestPerformedInspection;
    }

    private Remark getRemark(int indexInQuestion) {
        return remarks[indexInQuestion];
    }
}

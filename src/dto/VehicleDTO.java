
package dto;

/**
 * A data transfer class for a vehicle
 * @author Coyote
 */
public class VehicleDTO {
    private final String regNumber;
    /**
     * Creates a data transfer object for a vehicle.
     * @param regNo The identifier for the vehicle.
     */
    public VehicleDTO(String regNo){
        this.regNumber = regNo;
    }

    /**
     * Returns the vehicles registration number.
     * @return The vehicles registration number.
     */
    public String getRegNo() {
        return regNumber;
    }
    
    /**
     * Compares this object and the parameter object to see if they are equal.
     * @param obj The presumed equal object.
     * @return True if they are equal, false if not equal. 
     */
    public boolean equals(VehicleDTO obj){
        boolean theObjectsAreEqual = true;
        
        final boolean isAVehicleDTO = obj instanceof VehicleDTO;
        theObjectsAreEqual &= isAVehicleDTO;
        
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        final boolean otherObjectIsNull = obj == null;
        
        if(otherObjectIsNull){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        VehicleDTO otherVehicle = (VehicleDTO) obj;
        
        final boolean hasTheSameRegNumber = regNumber.equalsIgnoreCase(otherVehicle.getRegNo());
        theObjectsAreEqual &= hasTheSameRegNumber;
        
        return theObjectsAreEqual;
    }
}

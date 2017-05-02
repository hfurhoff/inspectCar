
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
    
    public boolean equals(VehicleDTO obj){
        boolean theObjectsAreEqual = true;
        theObjectsAreEqual &= (obj instanceof VehicleDTO);
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        if(obj == null){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        VehicleDTO otherVehicle = (VehicleDTO) obj;
        theObjectsAreEqual &= regNumber.equalsIgnoreCase(otherVehicle.getRegNo());
        return theObjectsAreEqual;
    }
}

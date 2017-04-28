
package dto;

/**
 * 
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
}


package externals;

/**
 * Specifies what to inspect on a vehicle.
 * @author Coyote
 */
public class SpecifiedInspection {
    private final String partToInspect;
    private final int cost;
    
    /**
     * Creates a specified inspection to be performed.
     * @param partToInspect Specifies what part to inspect on the vehicle.
     * @param cost Specifies the cost for this specified inspection.
     */
    public SpecifiedInspection(String partToInspect, int cost){
        this.partToInspect = partToInspect;
        this.cost = cost;
    }
    
    /**
     * Returns the cost for the specified inspection. 
     * @return The cost for performing the specified inspection. 
     */
    public int getCost(){
        return cost;
    }
}

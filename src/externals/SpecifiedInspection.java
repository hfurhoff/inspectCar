
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
    
    /**
     * Returns the part to be inspected.
     * @return The part to be inspected.
     */
    public String getPartToInspect(){
        return partToInspect;
    }
    
    @Override
    public String toString(){
        return ("Part to inspect and cost: " + partToInspect + ", " + cost);
    }
    
    public boolean equals(Object obj){
        boolean theObjectsAreEqual = true;
        theObjectsAreEqual &= (obj instanceof SpecifiedInspection);
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        if(obj == null){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        SpecifiedInspection otherSpecInsp = (SpecifiedInspection) obj;
        theObjectsAreEqual &= this.toString().equalsIgnoreCase(otherSpecInsp.toString());
        return theObjectsAreEqual;
    }
}

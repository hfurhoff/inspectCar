
package dto;

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
    
    /**
     * Returns the stringrepresentation of the object.
     * @return The stringrepresentation of the object.
     */
    @Override
    public String toString(){
        return ("Part to inspect and cost: " + partToInspect + ", " + cost);
    }
    
    /**
     * Compares this object and the parameter object to see if they are equal.
     * @param obj The presumed equal object.
     * @return True if they are equal, false if not equal. 
     */
    public boolean equals(Object obj){
        boolean theObjectsAreEqual = true;
        
        final boolean isASpecifiedInspection = obj instanceof SpecifiedInspection;
        theObjectsAreEqual &= isASpecifiedInspection;
        
        if(theObjectsAreEqual == false)
            return theObjectsAreEqual;
        
        final boolean otherObjestIsNull = obj == null;
        
        if(otherObjestIsNull){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        SpecifiedInspection otherSpecInsp = (SpecifiedInspection) obj;
        
        final boolean hasTheSameStringRepresentation = this.toString().equalsIgnoreCase(otherSpecInsp.toString());
        theObjectsAreEqual &= hasTheSameStringRepresentation;
        
        return theObjectsAreEqual;
    }
}

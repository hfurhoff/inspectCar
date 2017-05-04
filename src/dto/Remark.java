
package dto;

/**
 * Stores a comment and a pass or fail result for a part of an inspection.
 * @author Coyote
 */
public class Remark {
    private final String remark;
    private final boolean passed;
    
    /**
     * Creates a new remark for a part of an inspection.
     * @param remark The inspectors comment about the result for the particular part of the inspection.
     * @param passed The pass or fail reult for the particular part of the inspection.
     */
    public Remark(String remark, boolean passed){
        this.remark = remark;
        this.passed = passed;
    }

    /**
     * Returns the boolean result a specific inspection.
     * @return The boolean result a specific inspection.
     */
    public boolean getPassed() {
        return passed;
    }
    
    /**
     * Returns the remark entered by an inspector.
     * @return The remark entered by an inspector.
     */
    public String getRemark(){
        return remark;
    }
    
    /**
     * Compares this object and the parameter object to see if they are equal.
     * @param obj The presumed equal object.
     * @return True if they are equal, false if not equal. 
     */
    @Override
    public boolean equals(Object obj){
        boolean theObjectsAreEqual = true;
        
        final boolean isARemark = obj instanceof Remark;
        theObjectsAreEqual &= isARemark;
        
        if(theObjectsAreEqual == false){
             return theObjectsAreEqual;
        }
        
        final boolean otherObjectIsNull = obj == null;
        
        if(otherObjectIsNull){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        Remark otherRemark = (Remark) obj;
        
        final boolean hasTheSameComment = remark.equalsIgnoreCase(otherRemark.getRemark());
        theObjectsAreEqual &= hasTheSameComment;
        
        final boolean hasSameOutcome = passed == otherRemark.getPassed();
        theObjectsAreEqual &= hasSameOutcome;
        
        return theObjectsAreEqual;
    }
}

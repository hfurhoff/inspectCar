
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
    
    @Override
    public boolean equals(Object obj){
        boolean theObjectsAreEqual = true;
        theObjectsAreEqual &= (obj instanceof Remark);
        if(theObjectsAreEqual == false){
             return theObjectsAreEqual;
        }

        if(obj == null){
            theObjectsAreEqual = false;
            return theObjectsAreEqual;
        }
        
        Remark otherRemark = (Remark) obj;
        theObjectsAreEqual &= remark.equalsIgnoreCase(otherRemark.getRemark());
        theObjectsAreEqual &= passed == otherRemark.getPassed();
        return theObjectsAreEqual;
    }
}

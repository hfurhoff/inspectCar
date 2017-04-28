
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
}

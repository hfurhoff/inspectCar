
package externals;


public class SpecifiedInspection {
    private final String partToInspect;
    private final int cost;
    
    public SpecifiedInspection(String partToInspect, int cost){
        this.partToInspect = partToInspect;
        this.cost = cost;
    }
    
    public int getCost(){
        return cost;
    }
}


package externals;

/**
 * This class is a placeholder for the external system that is the garagedoor
 * @author Coyote
 */
public class GarageDoor {
    private boolean isOpen;
    
    /**
     * Creates a dummy garagedoor and initiates the door to be closed.
     */
    public GarageDoor(){
        this.isOpen = false;
    }
    
    /**
     * Opens the door.
     */
    public void openDoor(){
        this.isOpen = true;
    }
    
    /**
     * Closes the door.
     */
    public void closeDoor(){
        this.isOpen = false;
    }
    
    /**
     * Returns the stringrepresentation of the object.
     * @return The stringrepresentation of the object.
     */
    @Override
    public String toString(){
        if(isOpen)
            return "Garagedoor is open";
        else
            return "Garagedoor is closed";
    }
}

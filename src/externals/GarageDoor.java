
package externals;

/**
 * This class is a placeholder for the external system that is the garagedoor
 * @author Coyote
 */
public class GarageDoor {
    private boolean isOpen;
    private static final GarageDoor THIS = new GarageDoor();
    
    
    public static GarageDoor getGarageDoor(){
        return THIS;
    }
    
    /**
     * Creates a dummy garagedoor and initiates the door to be closed.
     */
    private GarageDoor(){
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

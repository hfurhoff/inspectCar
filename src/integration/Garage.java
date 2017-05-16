
package integration;
import externals.GarageDoor;
import externals.Display;
import static externals.Display.getDisplay;
import static externals.GarageDoor.getGarageDoor;

/**
 * This class is responsible for making calls to the external systems controlling the garagedoor and the display.
 * @author Coyote
 */
public class Garage {
    GarageDoor door;
    Display disp;
    
    /**
     * Sets up a connection to the external systems garagedoor and display. 
     */
    public Garage(){
        this.door = getGarageDoor();
        this.disp = getDisplay();
    }

    /**
     * Opens the door and displays next number.
     */
    public void nextCustomer(){
        door.openDoor();
        disp.showNextNumber();
    }
    
    /**
     * Closes the door.
     */
    public void closeDoor(){
        door.closeDoor();
    }
    
    /**
     * Makes a stringrepresentation of the instance.
     * @return The stringrepresentation of the instance.
     */
    @Override
    public String toString(){
        return ("The garage has a door and a display. " + door.toString() + ". " + disp.toString() + ".");
    }
}

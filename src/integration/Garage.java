
package integration;
import externals.GarageDoor;
import externals.Display;

/**
 * 
 * @author Coyote
 */
public class Garage {
    GarageDoor door;
    Display disp;
    
    /**
     * Sets up a connection to the external systems garagedoor and display. 
     */
    public Garage(){
        this.door = new GarageDoor();
        this.disp = new Display();
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
}

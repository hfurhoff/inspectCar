
package integration;
import externals.GarageDoor;
import externals.Display;

public class Garage {
    GarageDoor door;
    Display disp;
    
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

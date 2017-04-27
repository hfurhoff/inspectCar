
package externals;


public class GarageDoor {
    private boolean isOpen;
    
    public GarageDoor(){
        this.isOpen = false;
    }
    
    public void openDoor(){
        this.isOpen = true;
    }
    
    public void closeDoor(){
        this.isOpen = false;
    }
}


package externals;

/**
 * This class is a placeholder for the external system that is the display.
 * @author Coyote
 */
public class Display {
    private int numberToDisplay;
    
    /**
     * Creates a dummy display and initiates the number on the display to be zero.
     */
    public Display(){
        this.numberToDisplay = 0;
    }
    
    /**
     * Shows the next number on the display from 000 to 999.
     */
    public void showNextNumber(){
        int maximumNumberToDisplay = 1000;
        this.numberToDisplay++;
        resetIfNecessary(maximumNumberToDisplay);
    }

    private void resetIfNecessary(int maximumNumberToDisplay) {
        this.numberToDisplay = this.numberToDisplay % maximumNumberToDisplay;
    }
    
    /**
     * Returns the stringrepresentation off the display.
     * @return The stringrepresentation off the display.
     */
    public String toString(){
        return ("Display is showing number " + numberToDisplay);
    }
}

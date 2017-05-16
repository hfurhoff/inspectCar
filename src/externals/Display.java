
package externals;

/**
 * This class is a placeholder for the external system that is the display.
 * @author Coyote
 */
public class Display {
    private int numberToDisplay;
    private static final Display THIS = new Display();
    
    /**
     * A getter for the singleton class Display.
     * @return The only instance of the class.
     */
    public static Display getDisplay(){
        return THIS;
    }
    
    private Display(){
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

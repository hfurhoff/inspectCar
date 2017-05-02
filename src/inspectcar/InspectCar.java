/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inspectcar;

import startUp.StartUp;
import view.View;

/**
 * 
 * @author Coyote
 */
public class InspectCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StartUp programStarter = new StartUp();
        View view = programStarter.runStartUp();
        view.runProgram();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import tools.ConsoleLogger;
import tools.Logger;
import view.View;

/**
 * The main.
 * @author Coyote
 */
public class InspectCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("************************************************************************************************");
        System.out.println("RUNNING PROGRAM WITH ERRORS LOGGED TO FILE");
        System.out.println("************************************************************************************************\n");

        StartUp programStarter = new StartUp();
        View view = programStarter.runStartUp();
        view.runProgram();
        
        System.out.println("\n************************************************************************************************");
        System.out.println("RUNNING PROGRAM WITH ERRORS LOGGED TO CONSOLE");
        System.out.println("************************************************************************************************\n");
        
        Logger logger = new ConsoleLogger();
        view.setLogger(logger);
        view.runProgram();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.Controller;
import tools.Logger;
import tools.FileLogger;
import view.InspectionStatsView;
import view.View;

/**
 * This class is responsible for setting up the environment in which the system will operate.
 * @author Coyote
 */
public class StartUp {

    /**
     * Creates an instance of the class StartUp.
     */
    public StartUp(){
        
    }

    /**
     * Runs the startup procedure.
     * @return The view that will run the program.
     */
    public View runStartUp() {
        Controller contr = new Controller();
        contr.addObserver(InspectionStatsView.getObserver());
        Logger firstLogger = new FileLogger();
        return new View(contr, firstLogger);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.InspectionObserver;

/**
 * An observerclass that displays the number of passed and failed inspections.
 * @author Coyote
 */
public class InspectionStatsView implements InspectionObserver{
    
    private int noOfPassed;
    private int noOfInspections;
    
    private static final InspectionObserver THIS = new InspectionStatsView();

    /**
     * A getter for the single instance of the singleton-class.
     * @return The sole instance of the class.
     */
    public static InspectionObserver getObserver() {
        return THIS;
    }
    
    private InspectionStatsView(){
        this.noOfInspections = 0;
        this.noOfPassed = 0;
    }
    
    /**
     * @see InspectionObserver. 
     */
    @Override
    public void newResult(boolean passed) {
        noOfInspections++;
        
        if(passed){
            noOfPassed++;
        }
        
        System.out.println("------------------------------------------------------------");
        System.out.println("|                   STATISTICS DISPLAY                     |");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|   Total number of vehicles inspected:             " + noOfInspections + "      |");
        System.out.println("|   Number of vehicles that passed the inspections: " + noOfPassed + "      |");
        System.out.println("|   Number of vehicles that failed the inspections: " + (noOfInspections - noOfPassed) + "      |");
        System.out.println("------------------------------------------------------------");        
    }
    
}

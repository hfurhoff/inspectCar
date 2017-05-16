/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import dto.CreditCardDTO;
import dto.Remark;
import dto.SpecifiedInspection;
import integration.IllegalRegistrationNumberException;
import tools.Logger;
import tools.StateHandler;

/**
 * This class is a placeholder for the entire view.
 * @author Coyote
 */
public class View {

    private final Controller contr;
    private Logger logger;
    
    /**
     * Creates an instance of the class view.
     * @param contr The controller that the view will use to run the program.
     * @param logger
     */
    public View(Controller contr, Logger logger) {
        this.contr = contr;
        this.logger = logger;
    }

    /**
     * Runs the program once and makes printouts of the progress.
     */
    public void runProgram() {
        StateHandler printer = new StateHandler();
        printer.print(contr.getCurrentState());
        
        contr.startNewInspection();
        printer.print(contr.getCurrentState());
        
        contr.closeGarageDoor();
        printer.print(contr.getCurrentState());
        
        int cost = 0;
        String regNo = "666HEL";

        try{
            cost = contr.calculateCostForInspectionBasedOnVehicle(regNo);
        }
        catch(IllegalRegistrationNumberException exc){
            handleExc(("\nEXCEPTION: " + regNo + " is not a valid registration number. Please try again.\n"), exc);
            regNo = "123ABC";

            try{
                cost = contr.calculateCostForInspectionBasedOnVehicle(regNo);
            }
            catch(IllegalRegistrationNumberException exception){
                handleExc(("\nEXCEPTION: " + regNo + " is not a valid registration number. Please try again.\n"), exception);
            }
        }
        
        printer.print(contr.getCurrentState());
        System.out.println("The cost for inspecting the vehicle with registration number " + regNo + " is " + cost + ".");
        
        int pin = 1234;
        String number = "12345678900987654321";
        String holder = "Kalle Karlsson";
        int expiryMonth = 8;
        int expiryYear = 2020;
        int cvc = 911;
        CreditCardDTO creditcard = new CreditCardDTO(pin, number, holder, expiryMonth, expiryYear, cvc);
        contr.pay(creditcard);
        printer.print(contr.getCurrentState());
        
        while(contr.hasMoreInspections()){
            printer.print(contr.getCurrentState());
            
            SpecifiedInspection inspection = contr.getNextSpecifiedInspection();
            printer.print(contr.getCurrentState());
            System.out.println("The inspection retrieved specified to inspect the following parts: " + inspection.getPartToInspect());
            
            String commentOnInspectedPart = "Everything looked great!";
            boolean partApproved = true;
            Remark remark = new Remark(commentOnInspectedPart, partApproved);
            contr.enterRemark(remark);
            printer.print(contr.getCurrentState());
        }
    }

    private void handleExc(String errorMessageForUser,Exception exc) {
        System.out.println(errorMessageForUser);
        logger.log(exc);
    }
    
    public void setLogger(Logger logger){
        this.logger = logger;
    }
}

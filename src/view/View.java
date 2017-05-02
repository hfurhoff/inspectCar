/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import dto.CreditCardDTO;
import dto.Remark;
import externals.SpecifiedInspection;
import stateHandler.StatePrinter;

/**
 * This class is a placeholder for the entire view.
 * @author Coyote
 */
public class View {

    private final Controller contr;
    
    /**
     * Creates an instance of the class view.
     * @param contr The controller that the view will use to run the program.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Runs the program once.
     */
    public void runProgram() {
        StatePrinter printer = new StatePrinter();
        printer.print(contr.getCurrentState());
        
        contr.startNewInspection();
        printer.print(contr.getCurrentState());
        
        contr.closeGarageDoor();
        printer.print(contr.getCurrentState());
        
        String regNo = "123ABC";
        int cost = contr.calculateCostForInspectionBasedOnVehicle(regNo);
        printer.print(contr.getCurrentState());
        System.out.println("The cost for inspecting the vehicle with registration number " + regNo + " was " + cost + ".");
        
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
    
}

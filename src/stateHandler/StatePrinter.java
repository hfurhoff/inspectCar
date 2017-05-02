/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateHandler;

/**
 * Prints a certain string in response to some state
 * @author Coyote
 */
public class StatePrinter {

    /**
     * Prints a certain string in response to some state.
     * @param state The state that decides which string to be printed.
     */
    public void print(State state) {
        switch(state){
            case NO_INSPECTION_HAS_BEGUN:
                System.out.println("No inspection has begun.");
                break;
                
            case AN_INSPECTION_HAS_STARTED:
                System.out.println("An inspection has started.");
                break;
                
            case DOOR_HAS_CLOSED:
                System.out.println("The door has closed.");
                break;
                
            case REGISTRATION_NUMBER_HAS_BEEN_ENTERED_AND_COST_HAS_BEEN_RETURNED:
                System.out.println("A registration number has been entered and a cost has been returned.");
                break;
                
            case CUSTOMER_HAS_PAYED_WITH_AN_APPROVED_CREDITCARD:
                System.out.println("Customer has payed with an approved creditcard and a receipt has been printed.");
                break;
                
            case CUSTOMER_HAS_TRIED_TO_PAY_WITH_A_NONAPPROVED_CREDITCARD:
                System.out.println("Customer has tried to pay with a creditcard but it wasnt approved and a receipt has been printed.");
                break;
                
            case THERE_ARE_MORE_INSPECTIONS_TO_BE_MADE:
                System.out.println("There are inspections to be made.");
                break;
                
            case THERE_ARE_NO_MORE_INSPECTIONS:
                System.out.println("There are no inspections to be made.");
                break;
                
            case INSPECTOR_GOT_ANOTHER_INSPECTION:
                System.out.println("Inspector has retrieved an inspection from the system.");
                break;
                
            case INSPECTOR_ENTERED_A_REMARK:
                System.out.println("The inspector has entered a remark.");
                break;
                
            case THE_INSPECTION_IS_FINISHED:
                System.out.println("The inspection is finished and the result has been printed.");
                break;
            
        }
    }
    
}

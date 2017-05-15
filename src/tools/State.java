/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 * An enum class to decrease bad smell and to keep track of the programs progress.
 * @author Coyote
 */
public enum State {
    NO_INSPECTION_HAS_BEGUN, 
    AN_INSPECTION_HAS_STARTED, 
    DOOR_HAS_CLOSED, 
    REGISTRATION_NUMBER_HAS_BEEN_ENTERED_AND_COST_HAS_BEEN_RETURNED, 
    CUSTOMER_HAS_PAYED_WITH_AN_APPROVED_CREDITCARD, 
    CUSTOMER_HAS_TRIED_TO_PAY_WITH_A_NONAPPROVED_CREDITCARD, 
    THERE_ARE_MORE_INSPECTIONS_TO_BE_MADE, 
    THERE_ARE_NO_MORE_INSPECTIONS, 
    INSPECTOR_GOT_ANOTHER_INSPECTION, 
    INSPECTOR_ENTERED_A_REMARK, 
    THE_INSPECTION_IS_FINISHED
}


package controller;

import dto.CreditCardDTO;
import dto.VehicleDTO;
import externals.SpecifiedInspection;
import integration.DatabaseManager;
import integration.Garage;
import integration.PaymentAuthorizer;
import integration.Printer;
import model.Inspection;
import model.Payment;

/**
 * This class is responsible for forwarding calls from the view to the correct objects.
 * @author Coyote
 */
public class Controller {
    private final Garage garage;
    private final DatabaseManager dbm;
    private final PaymentAuthorizer bank;
    private final Printer printer;
    
    private Inspection inspection;
    private String[] states = { "Inspection has not begun.", 
                                "Inspection has started.", 
                                "Door has closed.", 
                                "Registrationnumber has been entered and cost has been returned.", 
                                "", 
                                ""};
    private int currentStateIndex;
    
    /**
     *Creates an instance of the object Controller.
     */
    public Controller(){
        this.garage = new Garage();
        this.dbm = new DatabaseManager();
        this.bank = new PaymentAuthorizer();
        this.printer = new Printer();
        this.inspection = null;
        this.currentStateIndex = 0;
    }
    
    /**
     * Makes it possible for a new customer to enter the garage.
     */
    public void startNewInspection(){
        garage.nextCustomer();
        this.currentStateIndex = 1;
    }
    
    /**
     * Closes the garage door so an inspection can immense.
     */
    public void closeGarageDoor(){
        garage.closeDoor();
        this.currentStateIndex = 2;
    }
    /**
     * Method to get the cost of inspection for a specific vehicle
     * @param vehicle the vehicle to inspect.
     * @return the cost for inspecting the specified vehicle.
     */
    public int calculateCostForInspectionBasedOnVehicle(VehicleDTO vehicle){
        SpecifiedInspection[] inspectionsToBeMade = dbm.getInspectionsForVehicle(vehicle);
        this.inspection = new Inspection(vehicle, inspectionsToBeMade);
        this.currentStateIndex = 3;
        return this.inspection.getCost();
    }
    
    /**
     * This method is called so that the inspection company can be compensated for the cost of making the inspection.
     * @param creditCard The customers creditcard that will pay for the cost of the inspection.
     */
    public void pay(CreditCardDTO creditCard){
        Payment currentPayment = new Payment(creditCard, inspection.getCost(), bank, printer);
        boolean approvedPayment = currentPayment.getApproved();
        this.currentStateIndex = 4;
        if(approvedPayment){
            states[currentStateIndex] = "Customer has payed with a creditcard and the payment was approved";
        }
        else{
            states[currentStateIndex] = "Customer has tried to pay with a creditcard but the payment was not approved";
        }
    }
    
    /**
     * Since we wont make the view i will use state transcripts instead to track the progress of the program.
     * @return The current state of which the program is in.
     */
    public String getCurrentState(){
        return states[currentStateIndex];
    }
}

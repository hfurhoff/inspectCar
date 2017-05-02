
package controller;

import dto.CreditCardDTO;
import dto.Remark;
import stateHandler.State;
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
    private State currentState;
    
    /**
     *Creates an instance of the object Controller.
     */
    public Controller(){
        this.garage = new Garage();
        this.dbm = new DatabaseManager();
        this.bank = new PaymentAuthorizer();
        this.printer = new Printer();
        this.inspection = null;
        this.currentState = State.NO_INSPECTION_HAS_BEGUN;
    }
    
    /**
     * Makes it possible for a new customer to enter the garage.
     */
    public void startNewInspection(){
        garage.nextCustomer();
        this.currentState = State.AN_INSPECTION_HAS_STARTED;
    }
    
    /**
     * Closes the garage door so an inspection can immense.
     */
    public void closeGarageDoor(){
        garage.closeDoor();
        this.currentState = State.DOOR_HAS_CLOSED;
    }
    
    /**
     * Method to get the cost of inspection for a vehicle specified by a registration number.
     * @param regNo the registration number for the vehicle to inspect.
     * @return the cost for inspecting the specified vehicle.
     */
    public int calculateCostForInspectionBasedOnVehicle(String regNo) {
        VehicleDTO vehicle = new VehicleDTO(regNo);
        SpecifiedInspection[] inspectionsToBeMade = dbm.getInspectionsForVehicle(vehicle);
        this.inspection = new Inspection(vehicle, inspectionsToBeMade);
        this.currentState = State.REGISTRATION_NUMBER_HAS_BEEN_ENTERED_AND_COST_HAS_BEEN_RETURNED;
        return this.inspection.getCost();
    }
    
    /**
     * This method is called so that the inspection company can be compensated for the cost of making the inspection.
     * @param creditCard The customers creditcard that will pay for the cost of the inspection.
     */
    public void pay(CreditCardDTO creditCard){
        Payment currentPayment = new Payment(creditCard, inspection.getCost(), bank, printer);
        boolean approvedPayment = currentPayment.getApproved();
        if(approvedPayment){
            this.currentState = State.CUSTOMER_HAS_PAYED_WITH_AN_APPROVED_CREDITCARD;
        }
        else{
            this.currentState = State.CUSTOMER_HAS_TRIED_TO_PAY_WITH_A_NONAPPROVED_CREDITCARD;
        }
    }
    
    /**
     * This method is a way for the view to ask if there are more inspections to come.
     * @return A boolean answer to the statement "There are more inspections to be performed".
     */
    public boolean hasMoreInspections(){
        if(inspection.hasMoreInspections())
            this.currentState = State.THERE_ARE_MORE_INSPECTIONS_TO_BE_MADE;
        else
            this.currentState = State.THERE_ARE_NO_MORE_INSPECTIONS;
        return inspection.hasMoreInspections();
    }
    
    /**
     * Provides the next specified inspection to be performed.
     * @return The next inspection to be performed by the inspector.
     */
    public SpecifiedInspection getNextSpecifiedInspection(){
        this.currentState = State.INSPECTOR_GOT_ANOTHER_INSPECTION;
        return inspection.getNextSpecifiedInspection();
    }
    
    /**
     * Adds the remark entered by the inspector and prints the finished result if there are no more inspections to be made.
     * @param remark The remark for the latest specified inspection performed.
     */
    public void enterRemark(Remark remark){
        inspection.addRemark(remark);
        this.currentState = State.INSPECTOR_ENTERED_A_REMARK;
        if(! (inspection.hasMoreInspections())){
            inspection.finishedWithInspection(dbm, printer);
            inspection = null;
            this.currentState = State.THE_INSPECTION_IS_FINISHED;
        }
    }
    
    /**
     * Since we wont make the view i will use states instead to track the progress of the program.
     * @return The current state of which the program is in.
     */
    public State getCurrentState(){
        return currentState;
    }
}

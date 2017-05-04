
package model;

import dto.CreditCardDTO;
import dto.Date;
import dto.Receipt;
import integration.PaymentAuthorizer;
import integration.Printer;

/**
 * The class responsible to make the payment
 * @author Coyote
 */
public class Payment {
    
    private final CreditCardDTO creditCard;
    private final int cost;
    private final PaymentAuthorizer bank;
    private final Date paymentDate;
    private final boolean paymentApproved;
    private final Receipt receiptForCurrentTransaction;
    
    /**
     * This is the constructor for the payment. Since a payment is an event that 
     * passes quickly this constructor not only saves the parameters as 
     * variables but also uses these in calls to other objects to create the 
     * event of a payment. 
     * @param creditCard The creditcard that will try and fund the payment.
     * @param cost The cost of the inspction that the payment is a compensation 
     * for.
     * @param bank The payment authorization that will need to approve the 
     * payment. 
     * @param printer The printer that will print the receipt proving the 
     * payment.
     */
    public Payment(CreditCardDTO creditCard, int cost, PaymentAuthorizer bank, 
            Printer printer) {
        this.creditCard = creditCard;
        this.cost = cost;
        this.bank = bank;
        paymentDate = createPaymentDate();
        paymentApproved = sendPaymentRequestToAuthorizer();
        receiptForCurrentTransaction = createReceipt();
        
        final String receiptInTextForm = receiptForCurrentTransaction.getTextToPrint();
        printer.print(receiptInTextForm);
    }
    
    /**
     * Creates a date for when the payment took place
     * @return The date of the payment
     */
    private Date createPaymentDate() {
        return new Date();
    }

    /**
     * Sends a paymentrequest for the cost with information about the creditcard 
     * to the payment authorizer.
     */
    private boolean sendPaymentRequestToAuthorizer() {
        return bank.authorizePayment(creditCard, cost);
    }

    /**
     * Creates a receipt for the current payment
     * @return Returns the receipt proving the payment.
     */
    private Receipt createReceipt() {
        return new Receipt(this);
    }

    /**
     * Returns the variable approved which represents if the creditcardpayment 
     * were approved or not
     * @return True indicates that the payment was approved and false that it 
     * was declined
     */
    public boolean getApproved() {
        return paymentApproved;
    }

    /**
     * A getter for the cost that the payment is a compensation for.
     * @return The cost that the payment is a compensation for.
     */
    public int getCost() {
        return cost;
    }

    /**
     * A getter for the date that the payment was made.
     * @return The date the payment was made.
     */
    public Date getPaymentDate() {
        return paymentDate;
    }
}

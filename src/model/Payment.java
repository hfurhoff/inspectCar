
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
    
    private boolean paymentApproved;
    
    /**
     * This is the constructor for the payment. Since a payment is an event that 
     * passes quickly this constructor does not save the parameters as variables 
     * but only uses these in calls to other objects to create the event of a 
     * payment. 
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
        Date paymentDate = createPaymentDate();
        sendPaymentRequestToAuthorizer(bank, creditCard, cost);
        Receipt receiptForCurrentTransaction = createReceipt(cost, paymentDate);
        printer.printReceipt(receiptForCurrentTransaction);
    }
    
    /**
     * Creates a date for when the payment took place
     * @return The date of the payment
     */
    private Date createPaymentDate() {
        Date paymentDate = new Date();
        return paymentDate;
    }

    /**
     * Sends a paymentrequest for the cost with information about the creditcard 
     * to the specified payment authorizer
     * @param bank The payment authorizer that the request will be sent to.
     * @param creditCard The credit card from where the money will be drawn.
     * @param cost The amount that needs to be on the account for the request to 
     * be approved.
     */
    private void sendPaymentRequestToAuthorizer(PaymentAuthorizer bank, 
            CreditCardDTO creditCard, int cost) {
        this.paymentApproved = bank.authorizePayment(creditCard, cost);
    }

    /**
     * Creates a receipt for the current payment
     * @param cost The cost that will be compensated with the payment
     * @param paymentDate The date when the payment was made
     * @return Returns the receipt proving the payment.
     */
    private Receipt createReceipt(int cost, Date paymentDate) {
        Receipt receiptForCurrentTransaction = new Receipt(cost, paymentDate, 
                paymentApproved);
        return receiptForCurrentTransaction;
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
    
}

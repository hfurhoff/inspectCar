
package integration;

import dto.CreditCardDTO;

/**
 * This class is responsible for approving creditcardpayments.
 * @author Coyote
 */
public class PaymentAuthorizer {

    /**
     * Since this is a dummy class the constructor is empty.
     */
    public PaymentAuthorizer(){
        
    }

    /**
     * A dummy assesment of the creditcard.
     * @param creditCard The creditcard to be assest.
     * @param cost The cost that the credit card needs to have.
     * @return Returns true if the cost is lower then the reditcard balance.
     */
    public boolean authorizePayment(CreditCardDTO creditCard, int cost) {
        boolean approved = false;
        int creditcardBalance = 1000;
        
        final boolean costIsLowerThenBalance = cost < creditcardBalance;
        if(costIsLowerThenBalance)
            approved = true;
        
        return approved;
    }
}

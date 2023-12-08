package model;

/**
 *
 * @author ACER
 */
public class CustomerLoanModel {
        private String customerId;
        private int loanNumber;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    @Override
    public String toString() {
        return "CustomerLoanModel{" + "customerId=" + customerId + ", loanNumber=" + loanNumber + '}';
    }
        
}

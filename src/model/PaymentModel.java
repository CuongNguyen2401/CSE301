package model;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class PaymentModel {
 private int loanPaymentNumber;
 private int loanNumber;
 private Date paymentDate;
 private float amount;

    public int getLoanPaymentNumber() {
        return loanPaymentNumber;
    }

    public void setLoanPaymentNumber(int loanPaymentNumber) {
        this.loanPaymentNumber = loanPaymentNumber;
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentModel{" + "loanPaymentNumber=" + loanPaymentNumber + ", loanNumber=" + loanNumber + ", amount=" + amount + '}';
    }
 
}

package model;

/**
 *
 * @author ACER
 */
public class LoanModel {
    private int loanNumber;
    private float loanAmount;
    private int branch_id;

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    @Override
    public String toString() {
        return "LoanModel{" + "loanNumber=" + loanNumber + ", loanAmount=" + loanAmount + ", branch_id=" + branch_id + '}';
    }
    
}

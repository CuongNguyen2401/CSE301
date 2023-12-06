package model;

/**
 *
 * @author ACER
 */
public class SavingAccountModel {

    private String accountNumber;
    private double balance;
    private int branchID;
    private double interestRate;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingAccountModel{" + "accountNumber=" + accountNumber + ", balance=" + balance + ", branchID=" + branchID + ", interestRate=" + interestRate + '}';
    }
    
}

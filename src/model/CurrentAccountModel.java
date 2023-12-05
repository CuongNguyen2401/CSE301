package model;

/**
 *
 * @author ACER
 */
public class CurrentAccountModel {

    private String accountNumber;
    private double balance;
    private int branchID;
    private double overdrafts;

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

    public double getOverdrafts() {
        return overdrafts;
    }

    public void setOverdrafts(double overdrafts) {
        this.overdrafts = overdrafts;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" + "accountNumber=" + accountNumber + ", balance=" + balance + ", branchID=" + branchID + ", overdrafts=" + overdrafts + '}';
    }

}

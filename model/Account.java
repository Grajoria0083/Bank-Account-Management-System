package model;

public class Account extends User{

    int accountNumber;

    String accountType;


    String bankName;
    String branch;
    String ifscCode;

    long amount;


    public Account(int accountNumber, String bankName, String branch, String ifscCode, long amount) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.branch = branch;
        this.ifscCode = ifscCode;
        this.amount = amount;
    }


    public Account() {

    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", bankName='" + bankName + '\'' +
                ", branch='" + branch + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", accountType='" + accountType + '\'' +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pin=" + pin +
                '}';
    }
}

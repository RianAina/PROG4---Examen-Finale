package com.prog4.FinalWallet.Model;

import java.sql.Timestamp;

public class Withdrawal {
    long id;
    long idAccount;
    double withdrawalAmount;
    Timestamp withdrawalDate;


    public Withdrawal(long id, long idAccount, double withdrawalAmount, Timestamp withdrawalDate) {
        this.id = id;
        this.idAccount = idAccount;
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
    }


    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(int withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public Timestamp getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Timestamp withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }
}

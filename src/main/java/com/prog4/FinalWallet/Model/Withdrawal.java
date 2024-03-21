package com.prog4.FinalWallet.Model;

import java.sql.Timestamp;

public class Withdrawal {
    long id;
    long idAccount;
    Timestamp withdrawalDate;


    public Withdrawal(long id, long idAccount, Timestamp withdrawalDate) {
        this.id = id;
        this.idAccount = idAccount;
        this.withdrawalDate = withdrawalDate;
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

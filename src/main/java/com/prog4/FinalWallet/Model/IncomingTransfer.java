package com.prog4.FinalWallet.Model;
import java.sql.Date;
import java.sql.Timestamp;

public class IncomingTransfer {
    long id;
    long idAccount;
    double amount;
    String reason;
    Date effective_date;
    Date registration_date;


    public IncomingTransfer(long id, long idAccount, double amount, String reason,
                            Date effective_date, Date registration_date) {
        this.id = id;
        this.idAccount = idAccount;
        this.amount = amount;
        this.reason = reason;
        this.effective_date = effective_date;
        this.registration_date = registration_date;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(Date effective_date) {
        this.effective_date = effective_date;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
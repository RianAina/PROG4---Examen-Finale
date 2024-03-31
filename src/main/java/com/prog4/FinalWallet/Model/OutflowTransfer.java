package com.prog4.FinalWallet.Model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OutflowTransfer {

    long id;
    long idAccount;
    long idReceiver;
    boolean isSameBank;
    String  bankName;
    double transferAmount;
    String category;
    Timestamp effectiveDate;
    Timestamp registrationDate;
    String transactionReference;
    boolean isCanceled;

    public OutflowTransfer(long id, long idAccount, long idReceiver, boolean isSameBank, String bankName,
                           double transferAmount, String category, Timestamp effectiveDate,
                           Timestamp registrationDate, String transactionReference, boolean isCanceled) {
        this.id = id;
        this.idAccount = idAccount;
        this.idReceiver = idReceiver;
        this.isSameBank = isSameBank;
        this.bankName = bankName;
        this.transferAmount = transferAmount;
        this.category = category;
        this.effectiveDate = effectiveDate;
        this.registrationDate = registrationDate;
        this.transactionReference = transactionReference;
        this.isCanceled = isCanceled;
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

    public long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(long idReceiver) {
        this.idReceiver = idReceiver;
    }

    public boolean isSameBank() {
        return isSameBank;
    }

    public void setSameBank(boolean sameBank) {
        isSameBank = sameBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}

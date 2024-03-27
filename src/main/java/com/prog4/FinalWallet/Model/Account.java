package com.prog4.FinalWallet.Model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Account {
    long id;
    String firstName;
    String lastName;
    Date birthDate;
    double mensualSalary;
    double balance;
    boolean canTakeCredit;
    double credit;

    public Account(long id, String firstName, String lastName, Date birthDate, double mensualSalary,
                   double balance, boolean canTakeCredit, double credit) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.mensualSalary = mensualSalary;
        this.balance = balance;
        this.canTakeCredit = canTakeCredit;
        this.credit = credit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getMensualSalary() {
        return mensualSalary;
    }

    public void setMensualSalary(double mensualSalary) {
        this.mensualSalary = mensualSalary;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isCanTakeCredit() {
        return canTakeCredit;
    }

    public void setCanTakeCredit(boolean canTakeCredit) {
        this.canTakeCredit = canTakeCredit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}


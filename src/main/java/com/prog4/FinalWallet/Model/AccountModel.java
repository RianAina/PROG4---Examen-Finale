package com.prog4.FinalWallet.Model;

import java.time.LocalDate;

public class AccountModel {
    long id;
    String lastName;
    String firstName;
    LocalDate birthDate;
    int mensualSalary;

    AccountModel (long id, String lastName, String firstName, LocalDate birthDate, int mensualSalary){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.mensualSalary = mensualSalary;
    }
}

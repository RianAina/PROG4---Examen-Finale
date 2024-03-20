package com.prog4.FinalWallet.Model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountModel {
    long id;
    String lastName;
    String firstName;
    LocalDate birthDate;
    int mensualSalary;

    public AccountModel(long id, String lastName, String firstName, LocalDate birthDate, int mensualSalary){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.mensualSalary = mensualSalary;
    }

    public AccountModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getMensualSalary() {
        return mensualSalary;
    }

    public void setMensualSalary(int mensualSalary) {
        this.mensualSalary = mensualSalary;
    }
}

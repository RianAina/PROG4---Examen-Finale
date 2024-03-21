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
    int mensualSalary;

    public Account(long id, String firstName, String lastName, Date birthDate, int mensualSalary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.mensualSalary = mensualSalary;
    }

    public Account(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getMensualSalary() {
        return mensualSalary;
    }

    public void setMensualSalary(int mensualSalary) {
        this.mensualSalary = mensualSalary;
    }
}

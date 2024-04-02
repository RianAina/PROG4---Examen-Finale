package com.prog4.FinalWallet.Model;

        import lombok.EqualsAndHashCode;
        import lombok.NoArgsConstructor;
        import lombok.ToString;

        import java.sql.Date;
        import java.sql.Timestamp;
        import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BankStatment {
    Timestamp transactionDate;
    String reference;
    String motif;
    double credit;
    double debit;


    public BankStatment(Timestamp transactionDate, String reference, String motif, double credit, double debit) {
        this.transactionDate = transactionDate;
        this.reference = reference;
        this.motif = motif;
        this.credit = credit;
        this.debit = debit;
    }


    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }
}


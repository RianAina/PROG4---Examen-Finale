package com.prog4.FinalWallet.Service;


import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Model.Withdrawal;
import com.prog4.FinalWallet.Repository.AccountRepository;
import com.prog4.FinalWallet.Repository.WithdrawalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class WithdrawalService {
    private WithdrawalRepository withdrawalRepository;
    private AccountRepository accountRepository;


    public List<Withdrawal> getAllWithdrawalHistory(){
        try {
            return this.withdrawalRepository.getAllWithdrawalHistory() ;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public List<Withdrawal> getWithdrawalHistoryById(Long id){
        try {
            return this.withdrawalRepository.getWithdrawalHistoryById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Transactional
    public String doWithdrawService(long id, double withdrawalAmount) throws SQLException {

        double balance = accountRepository.getAccountBalance(id);
        boolean creditStatus = accountRepository.getCreditStatus(id);
        double mensualSalary = accountRepository.getMensualSalary(id);
        double credit = 0;

        try {
            if (creditStatus){
                if ((balance = balance + mensualSalary/3) >= withdrawalAmount && 0 != withdrawalAmount){
                    withdrawalRepository.doWithdraw(id, withdrawalAmount);
                    balance = balance - withdrawalAmount;

                    if (balance < 0){
                        double NewCredit = Math.abs(balance);
                        credit = accountRepository.getAccountCredit(id);
                        credit = credit + NewCredit;
                        accountRepository.updateAccountCredit(credit, id);
                    }

                    return "Withdraw of " + withdrawalAmount + " successfully completed !";
                } else if (balance < withdrawalAmount && 0 != withdrawalAmount) {
                    return "Insufficient balance !" ;
                } else {
                    return "Invalid amount !";
                }
            } else {
                if (balance >= withdrawalAmount && 0 != withdrawalAmount){
                    withdrawalRepository.doWithdraw(id, withdrawalAmount);
                    return "Withdraw of " + withdrawalAmount + " successfully completed ! ";
                } else if (
                        (balance < withdrawalAmount)
                        && ((balance + balance/3) < withdrawalAmount)
                        && 0 != withdrawalAmount
                ) {
                    return "Insufficient balance and credit is not available";
                } else if (balance < withdrawalAmount && 0 != withdrawalAmount){
                    return "Insufficient balance !";
                } else {
                    return "Invalid amount !";
                }
            }


        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }


}

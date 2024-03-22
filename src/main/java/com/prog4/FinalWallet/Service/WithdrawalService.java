package com.prog4.FinalWallet.Service;


import com.prog4.FinalWallet.Model.Withdrawal;
import com.prog4.FinalWallet.Repository.AccountRepository;
import com.prog4.FinalWallet.Repository.WithdrawalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@AllArgsConstructor
@Service
public class WithdrawalService {
    private WithdrawalRepository withdrawalRepository;
    private AccountRepository accountRepository;


    @Transactional
    public String doWithdrawService(long id, int withdrawalAmount) throws SQLException {

        int balance = accountRepository.getAccountBalance(id);
        boolean creditStatus = accountRepository.getCreditStatus(id);
        int mensualSalary = accountRepository.getMensualSalary(id);

        try {
            if (creditStatus){
                balance = balance + mensualSalary/3;
                if (balance >= withdrawalAmount && 0 != withdrawalAmount){
                    withdrawalRepository.doWithdraw(id, withdrawalAmount);
                    return "Withdraw of " + withdrawalAmount + " successfully completed !";
                } else if (balance < withdrawalAmount) {
                    return "Insufficient balance !" ;
                } else {
                    return "Invalid amount !";
                }
            } else {
                if (balance >= withdrawalAmount && 0 != withdrawalAmount){
                    withdrawalRepository.doWithdraw(id, withdrawalAmount);
                    return "Withdraw of " + withdrawalAmount + " successfully completed ! ";
                } else if ((balance < withdrawalAmount) && ((balance + balance/3) < withdrawalAmount)) {
                    return "Insufficient balance and credit is not available";
                } else if (balance < withdrawalAmount){
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

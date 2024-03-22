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
    public String doWithdrawService(long id, int withdrawalAmount, Withdrawal withdrawal) throws SQLException {

        int balance = accountRepository.getAccountBalance(id);

        try {
            if ((balance + balance/3) >= withdrawalAmount){
                withdrawalRepository.doWithdraw(id, withdrawalAmount, withdrawal);
                return "Withdraw of " + withdrawalAmount + "done !";
            } else if ((balance + balance/3) < withdrawalAmount) {
                return "Insufficient balance !";
            } else {
                return "Error !";
            }


        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
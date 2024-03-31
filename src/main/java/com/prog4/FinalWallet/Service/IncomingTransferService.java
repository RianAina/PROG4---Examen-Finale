package com.prog4.FinalWallet.Service;

import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Model.IncomingTransfer;
import com.prog4.FinalWallet.Repository.AccountRepository;
import com.prog4.FinalWallet.Repository.IncomingTransferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@AllArgsConstructor
@Service
public class IncomingTransferService {
    private IncomingTransferRepository incomingTransferRepository;
    private AccountRepository accountRepository;


    /* -- CREATE -- */

    @Transactional
    public IncomingTransfer receiveTransfer(long id, IncomingTransfer incomingTransfer){
        try {
            incomingTransferRepository.receiveTransfer(incomingTransfer);

            double amountTransfer = incomingTransferRepository.getTransferAmount(id);
            double accountBalance = accountRepository.getAccountBalance(id);

            double NewaccountBalance = accountBalance + amountTransfer;

            this.accountRepository.updateBalanceAmount(NewaccountBalance, id);

            return incomingTransfer;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public double getTransferAmount(long id){
        try {
            return this.accountRepository.getAccountBalance(id);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}

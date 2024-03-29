package com.prog4.FinalWallet.Service;

import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Model.IncomingTransfer;
import com.prog4.FinalWallet.Repository.IncomingTransferRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

public class IncomingTransferService {
    private IncomingTransferRepository incomingTransferRepository;
    private Account account;


    /* -- CREATE -- */

    @Transactional
    public IncomingTransfer receiveTransfer(long id, IncomingTransfer incomingTransfer){
        try {
            incomingTransferRepository.receiveTransfer(incomingTransfer);
            double amountTransfer = incomingTransferRepository.getTransferAmount(id);


            return incomingTransfer;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

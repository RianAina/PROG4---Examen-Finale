package com.prog4.FinalWallet.Service;


import com.prog4.FinalWallet.Model.AccountModel;
import com.prog4.FinalWallet.Repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountService {
    private AccountRepository accountRepository;

    public List<AccountModel> getAllId(){
        try {
            return this.accountRepository.getAllId();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

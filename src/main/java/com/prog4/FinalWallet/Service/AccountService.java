package com.prog4.FinalWallet.Service;


import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountService {
    private AccountRepository accountRepository;


    /* -- CREATE -- */

    public Account createAccount(Account account){
        try {
            accountRepository.createAccount(account);
            return account;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }





    /* -- READ -- */

    public List<Account> getAllAccount(){
        try {
            return this.accountRepository.getAllAccount() ;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Account getAccountById(Long id){
        try {
            return this.accountRepository.getAccountById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    public int getAccountBalance(long id){
        try {
            return this.accountRepository.getAccountBalance(id);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }






    /* -- UPDATE -- */

    public Account updateAccountSalary(Long id, Account account){
        try {
            account.setId(id);
            accountRepository.updateAccountSalary(id , account);
            return account;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public Account setCreditStatus(Long id, Account account){
        try {
            account.setId(id);
            accountRepository.setCreditStatus(id , account);
            return account;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public Account updateBalance(Long id, Account account){
        try {
            account.setId(id);
            accountRepository.updateBalance(id , account);
            return account;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }





    /* -- DELETE -- */

    public String deleteAccount(int id){
        try {
            accountRepository.deleteAccount(id);
            return "Account deleted successfully";
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}

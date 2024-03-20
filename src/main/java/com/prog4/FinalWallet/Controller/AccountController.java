package com.prog4.FinalWallet.Controller;

import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
     private final AccountRepository accountRepository;

     public AccountController(AccountRepository accountRepository){
         this.accountRepository = accountRepository;
     };


}

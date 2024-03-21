package com.prog4.FinalWallet.Controller;

import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Repository.AccountRepository;
import com.prog4.FinalWallet.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;


    /* Get the list of all accounts */
    @GetMapping("/account")
    public List<Account> getAllAccount() {
        return this.accountService.getAllAccount();
    }

    /* Get an account by ID */
    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return this.accountService.getAccountById(id);
    }

    /* Create a new account */
    @PostMapping("/account")
    public Account createAccount (@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    /* Update the mensual salary of an account */
    @PutMapping("/account/{id}/{mensualSalary}")
    public Account updateSalaryAccount(@PathVariable int mensualSalary, @PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccount(mensualSalary, id, account);
    }

}

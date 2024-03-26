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


    /* -- Get request -- */

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





    /* -- Post request -- */

    /* Create a new account */
    @PostMapping("/account")
    public Account createAccount (@RequestBody Account account) {

        return accountService.createAccount(account);
    }






    /* -- Put request -- */

    /* Set the credit status to on or off */
    @PutMapping("/accountCredit/{id}")
    public Account setCreditStatus(@PathVariable Long id, @RequestBody Account account) {
        return accountService.setCreditStatus(id, account);
    }

    /* Update the mensual salary of an account */
    @PutMapping("/accountSalary/{id}")
    public Account updateAccountSalary(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccountSalary(id, account);
    }

    @PutMapping("/accountBalance/{id}")
    public Account updateBalance(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateBalance(id, account);
    }





    /* -- Delete request -- */

    /* Delete an account */
    @DeleteMapping("/account/{id}")
    public String deleteAccount(@PathVariable int id){
        return accountService.deleteAccount(id);
    }


}

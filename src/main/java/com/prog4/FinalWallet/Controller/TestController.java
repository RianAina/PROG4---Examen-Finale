package com.prog4.FinalWallet.Controller;

import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TestController {
    private final AccountService accountService;

    @GetMapping("/test")
    public String test() {
        return "This is the test";
    }

    @GetMapping("/All")
    public List<Account> getAllId() {
        return this.accountService.getAllId();
    }


}
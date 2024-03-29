package com.prog4.FinalWallet.Controller;


import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Model.Withdrawal;
import com.prog4.FinalWallet.Service.WithdrawalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@AllArgsConstructor
public class WithdrawalController {
    private WithdrawalService withdrawalService;


    /* -- Get request -- */

    @GetMapping("/withdrawal")
    public List<Withdrawal> getWithdrawalHistory () throws SQLException {
        return withdrawalService.getAllWithdrawalHistory();
    }


    @GetMapping("/withdrawal/{id}")
    public List<Withdrawal> getWithdrawalHistoryById(@PathVariable Long id) {
        return this.withdrawalService.getWithdrawalHistoryById(id);
    }



    /* -- Put request -- */

    /* Do a withdraw */
    @PutMapping("/withdrawal/{id}/{withdrawalAmount}")
    public String doWithdraw (@PathVariable long id, @PathVariable int withdrawalAmount) throws SQLException {
        return withdrawalService.doWithdrawService(id, withdrawalAmount);
    }
}

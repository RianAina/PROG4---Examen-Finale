package com.prog4.FinalWallet.Controller;


import com.prog4.FinalWallet.Model.Withdrawal;
import com.prog4.FinalWallet.Service.WithdrawalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@AllArgsConstructor
public class WithdrawalController {
    private WithdrawalService withdrawalService;

    /* Do a withdraw */
    @PutMapping("/withdraw/{id}/{amount}")
    public String doWithdraw (@PathVariable long id, @PathVariable int withdrawalAmount, @RequestBody Withdrawal withdrawal) throws SQLException {
        return withdrawalService.doWithdrawService(id, withdrawalAmount, withdrawal);
    }
}

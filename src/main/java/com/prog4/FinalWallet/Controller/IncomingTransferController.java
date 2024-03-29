package com.prog4.FinalWallet.Controller;

import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Model.IncomingTransfer;
import com.prog4.FinalWallet.Service.IncomingTransferService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class IncomingTransferController {
    private IncomingTransferService incomingTransferService;

    /* -- Post request -- */

    /* Create a new account */
    @PostMapping("/account/incoming/{id}")
    public IncomingTransfer receiveTransfer (@PathVariable long id, @RequestBody IncomingTransfer incomingTransfer) {
        return incomingTransferService.receiveTransfer(id, incomingTransfer);
    }
}

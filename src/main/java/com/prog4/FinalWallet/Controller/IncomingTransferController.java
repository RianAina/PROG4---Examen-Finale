package com.prog4.FinalWallet.Controller;

import com.prog4.FinalWallet.Model.IncomingTransfer;
import com.prog4.FinalWallet.Service.IncomingTransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class IncomingTransferController {
    private IncomingTransferService incomingTransferService;

    /* -- Post request -- */

    /* Create a new account */
    @PostMapping("/incoming/{id}")
    public IncomingTransfer receiveTransfer (@PathVariable long id, @RequestBody IncomingTransfer incomingTransfer) {
        return incomingTransferService.receiveTransfer(id, incomingTransfer);
    }


    /* -- Get request -- */
    @GetMapping("/incoming/amount/{id}")
    public double getTransferAmount(@PathVariable long id) {
        return incomingTransferService.getTransferAmount(id);
    }
}



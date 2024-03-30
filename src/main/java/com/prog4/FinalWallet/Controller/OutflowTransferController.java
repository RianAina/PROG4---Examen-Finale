package com.prog4.FinalWallet.Controller;

        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.OutflowTransfer;
        import com.prog4.FinalWallet.Service.AccountService;
        import com.prog4.FinalWallet.Service.OutflowTransferService;
        import lombok.AllArgsConstructor;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@AllArgsConstructor
public class OutflowTransferController {
    private OutflowTransferService outflowTransferService;






    /* -- Get request -- */








    /* -- Post request -- */

    @PostMapping("/outflow/{idAccount}/{idReceiver}")
    public String doTransfer (@RequestBody long idAccount,
                                       @RequestBody long idReceiver, @RequestBody OutflowTransfer outflowTransfer) {

        return outflowTransferService.doTransfer(idAccount, idReceiver, outflowTransfer);
    }






    /* -- Put request -- */







    /* -- Delete request -- */




}

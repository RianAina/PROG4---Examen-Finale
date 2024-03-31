package com.prog4.FinalWallet.Controller;

        import com.prog4.FinalWallet.Model.OutflowTransfer;
        import com.prog4.FinalWallet.Service.OutflowTransferService;
        import lombok.AllArgsConstructor;
        import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OutflowTransferController {
    private OutflowTransferService outflowTransferService;






    /* -- Get request -- */








    /* -- Post request -- */

    @PostMapping("/outflow")
    public String doTransfer (@RequestBody OutflowTransfer outflowTransfer) {

        return outflowTransferService.doTransfer(outflowTransfer);
    }






    /* -- Put request -- */

    @PutMapping("/outflow/{status}/{reference}")
    public OutflowTransfer setCanceleStatus (@PathVariable boolean status, @PathVariable String reference, @RequestBody OutflowTransfer outflowTransfer) {

        return outflowTransferService.setCanceleStatus(status, reference, outflowTransfer);
    }





    /* -- Delete request -- */




}

package com.prog4.FinalWallet.Controller;

        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.BankStatment;
        import com.prog4.FinalWallet.Service.AccountService;
        import com.prog4.FinalWallet.Service.BankStatmentService;
        import lombok.AllArgsConstructor;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@AllArgsConstructor
public class BankStatmentController {
    private BankStatmentService bankStatmentService;
    /* -- Get request -- */

    /* Get the list of all accounts */
        @GetMapping("/transaction/{a}/{b}")
    public List<BankStatment> getTransaction(@PathVariable String a,@PathVariable String b) {
        return this.bankStatmentService.getTransaction(a,b);
    }

}

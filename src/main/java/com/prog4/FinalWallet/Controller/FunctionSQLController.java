package com.prog4.FinalWallet.Controller;

        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.FunctionSQL;
        import com.prog4.FinalWallet.Model.IncomingTransfer;
        import com.prog4.FinalWallet.Service.FunctionSQLService;
        import com.prog4.FinalWallet.Service.IncomingTransferService;
        import lombok.AllArgsConstructor;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@AllArgsConstructor
@RestController
public class FunctionSQLController {
    private FunctionSQLService functionSQLService;

    @GetMapping("/function/1")
    public List<FunctionSQL> getAllAmount() {
        return this.functionSQLService.getAllAmount();
    }
}



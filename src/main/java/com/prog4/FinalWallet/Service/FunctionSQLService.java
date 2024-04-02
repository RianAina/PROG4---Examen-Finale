package com.prog4.FinalWallet.Service;

        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.FunctionSQL;
        import com.prog4.FinalWallet.Model.IncomingTransfer;
        import com.prog4.FinalWallet.Repository.AccountRepository;
        import com.prog4.FinalWallet.Repository.FunctionSQLRepository;
        import com.prog4.FinalWallet.Repository.IncomingTransferRepository;
        import lombok.AllArgsConstructor;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.sql.SQLException;
        import java.util.List;

@AllArgsConstructor
@Service
public class FunctionSQLService {
    private FunctionSQLRepository functionSQLRepository;

    public List<FunctionSQL> getAllAmount(){
        try {
            return this.functionSQLRepository.getAllAmount() ;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public double getSumAmount(){
        try {
            return this.functionSQLRepository.getSumAmount();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }


}

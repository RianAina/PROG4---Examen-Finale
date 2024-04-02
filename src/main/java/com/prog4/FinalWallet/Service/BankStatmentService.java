package com.prog4.FinalWallet.Service;


        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.BankStatment;
        import com.prog4.FinalWallet.Repository.AccountRepository;
        import com.prog4.FinalWallet.Repository.BankStatmentRepository;
        import lombok.AllArgsConstructor;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Service;

        import java.sql.SQLException;
        import java.util.List;

@AllArgsConstructor
@Service
public class BankStatmentService {
    private BankStatmentRepository bankStatmentRepository;


    /* -- CREATE -- */

    public List<BankStatment> getTransaction(String a, String b){
        try {
            return this.bankStatmentRepository.getTransaction(a,b) ;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

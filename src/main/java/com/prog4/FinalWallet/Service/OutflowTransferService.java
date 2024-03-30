package com.prog4.FinalWallet.Service;

        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.IncomingTransfer;
        import com.prog4.FinalWallet.Model.OutflowTransfer;
        import com.prog4.FinalWallet.Repository.AccountRepository;
        import com.prog4.FinalWallet.Repository.IncomingTransferRepository;
        import com.prog4.FinalWallet.Repository.OutflowTransferRepository;
        import lombok.AllArgsConstructor;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import java.security.SecureRandom;

        import java.sql.SQLException;

@AllArgsConstructor
@Service
public class OutflowTransferService {
    private OutflowTransferRepository outflowTransferRepository;
    private AccountRepository accountRepository;


    /* -- CREATE -- */

        public static String generateUniqueReference() {

             final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
             final int REFERENCE_LENGTH = 14;

            SecureRandom random = new SecureRandom();
            StringBuilder reference = new StringBuilder(REFERENCE_LENGTH);

            for (int i = 0; i < REFERENCE_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                reference.append(CHARACTERS.charAt(randomIndex));
            }

            return reference.toString();
        }



    @Transactional
    public String doTransfer(long idAccount, long idReceiver, OutflowTransfer outflowTransfer){
        try {
            String referenceUnique = generateUniqueReference();

            this.outflowTransferRepository.doTransfer(idAccount, idReceiver, outflowTransfer);
            this.outflowTransferRepository.setTransactionReference(referenceUnique);

            double senderBalance = accountRepository.getAccountBalance(idAccount);
            double receiverBalance = accountRepository.getAccountBalance(idReceiver);
            double transferAmount = outflowTransferRepository.getTransfertAmount(referenceUnique);


            if (outflowTransferRepository.isSameBankStatus(referenceUnique)){

                if (senderBalance >= transferAmount && transferAmount != 0) {
                    senderBalance = senderBalance - transferAmount;
                    receiverBalance = receiverBalance + transferAmount;

                    accountRepository.updateBalanceAmount(senderBalance, idAccount);
                    accountRepository.updateBalanceAmount(receiverBalance, idReceiver);

                    return "Transfert of " + transferAmount + " to id : " + idReceiver + "done !";

                } else if (senderBalance < transferAmount && transferAmount != 0) {

                    return "Insufficient balance !" ;

                } else {

                    return "Invalid transfer amount !";

                }
            } else {

                senderBalance = senderBalance - transferAmount;

                accountRepository.updateBalanceAmount(senderBalance, idAccount);

                return "Transfert of " + transferAmount + " into an external bank done !";
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

package com.prog4.FinalWallet.Repository;

        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.BankStatment;
        import lombok.AllArgsConstructor;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Repository;

        import java.util.ArrayList;
        import java.util.List;
        import java.sql.*;



@AllArgsConstructor
@Repository
public class BankStatmentRepository {
    private Connection connection;



    public BankStatment createNewInstance(ResultSet resultSet) throws SQLException {
        return new BankStatment(
                resultSet.getTimestamp("transaction_date"),
                resultSet.getString("reference"),
                resultSet.getString("motif"),
                resultSet.getDouble("credit"),
                resultSet.getDouble("debit")
        );
    }


    /* READ */

    public List<BankStatment> getTransaction(String a, String b) throws SQLException {
        String sql = "\n" +
                "SELECT \n" +
                "    COALESCE(w.withdrawal_date, it.effective_date, ot.effective_date) AS transaction_date,\n" +
                "    ot.transaction_reference AS reference,\n" +
                "    COALESCE(it.reason, ot.category) AS motif,\n" +
                "    CASE \n" +
                "        WHEN w.withdrawal_amount IS NOT NULL THEN NULL\n" +
                "        ELSE it.amount\n" +
                "    END AS credit,\n" +
                "    w.withdrawal_amount AS debit\n" +
                "FROM \n" +
                "    account a\n" +
                "LEFT JOIN \n" +
                "    withdrawal w ON a.id = w.id_account\n" +
                "LEFT JOIN \n" +
                "    incoming_transfer it ON a.id = it.id_account\n" +
                "LEFT JOIN \n" +
                "    outflow_transfer ot ON a.id = ot.id_account\n" +
                "WHERE \n" +
                "    COALESCE(w.withdrawal_date, it.effective_date, ot.effective_date) BETWEEN ? AND ?\n" +
                "ORDER BY \n" +
                "    transaction_date;\n";
        List<BankStatment> list = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setString(1, a);
        statement.setString(2, b);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                BankStatment bankStatment = createNewInstance(resultSet);
                list.add(bankStatment);
            }
        }
        return list;
    }

}
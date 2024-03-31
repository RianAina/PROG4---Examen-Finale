package com.prog4.FinalWallet.Repository;

import com.prog4.FinalWallet.Model.IncomingTransfer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;


@AllArgsConstructor
@Repository
public class IncomingTransferRepository {
    private Connection connection;

    public IncomingTransfer createNewInstance(ResultSet resultSet) throws SQLException{
        return new IncomingTransfer (
                resultSet.getLong("id"),
                resultSet.getLong("id_account"),
                resultSet.getDouble("amount"),
                resultSet.getString("reason"),
                resultSet.getDate("effective_date"),
                resultSet.getDate("registration_date")
        );
    }


    /* CREATE */

    public void receiveTransfer(IncomingTransfer incomingTransfer) throws SQLException {
        String sql = "INSERT INTO incoming_transfer (id_account, amount, reason) " +
                "VALUES (?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, incomingTransfer.getIdAccount());
            statement.setDouble(2, incomingTransfer.getAmount());
            statement.setString(3, incomingTransfer.getReason());

            statement.executeUpdate();
        }
    }



    /* READ */

    public double getTransferAmount(long id) throws SQLException{
        double amount = 0;
        String sql = "SELECT amount FROM incoming_transfer WHERE id = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            amount = resultSet.getDouble("amount");
        }
        return amount;
    }

}

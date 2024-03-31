package com.prog4.FinalWallet.Repository;

import com.prog4.FinalWallet.Model.OutflowTransfer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@Repository
public class OutflowTransferRepository {
    private Connection connection;

    public OutflowTransfer createNewInstance(ResultSet resultSet) throws SQLException {
        return new OutflowTransfer(
                resultSet.getLong("id"),
                resultSet.getLong("id_account"),
                resultSet.getLong("id_receiver"),
                resultSet.getBoolean("is_same_bank"),
                resultSet.getString("bank_name"),
                resultSet.getDouble("transfer_amount"),
                resultSet.getString("category"),
                resultSet.getTimestamp("effective_date"),
                resultSet.getTimestamp("registration_date"),
                resultSet.getString("transaction_reference"),
                resultSet.getBoolean("is_canceled")
        );
    }


    /* CREATE */

    public void doTransfer(OutflowTransfer outflowTransfer) throws SQLException {
        String sql = "INSERT INTO outflow_transfer (id_account, id_receiver, is_same_bank, bank_name, " +
                "transfer_amount, category, effective_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, outflowTransfer.getIdAccount());
            statement.setLong(2, outflowTransfer.getIdReceiver());
            statement.setBoolean(3, outflowTransfer.isSameBank());
            statement.setString(4, outflowTransfer.getBankName());
            statement.setDouble(5, outflowTransfer.getTransferAmount());
            statement.setString(6, outflowTransfer.getCategory());
            statement.setTimestamp(7, outflowTransfer.getEffectiveDate());

            statement.executeUpdate();
        }
    }




    /* READ */

    public boolean isSameBankStatus(String reference) throws SQLException{
        boolean status = true;
        String sql = "SELECT is_same_bank FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            status = resultSet.getBoolean("is_same_bank");
        }
        return status;
    }



    public Timestamp getEffectiveDate(String reference) throws SQLException{
        Timestamp effectiveDate;
        String sql = "SELECT effective_date FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            effectiveDate = resultSet.getTimestamp("effective_date");
            return effectiveDate;
        }
        return null;
    }



    public double getTransfertAmount(String reference) throws SQLException{
        double transfertAmount = 0;
        String sql = "SELECT transfer_amount FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            transfertAmount = resultSet.getDouble("transfer_amount");
        }
        return transfertAmount;
    }


    public long getIdAccount(String reference) throws SQLException{
        long idAccount = 0;
        String sql = "SELECT id_account FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            idAccount = resultSet.getLong("id_account");
        }
        return idAccount;
    }


    public long getIdReceiver(String reference) throws SQLException{
        long idReceiver = 0;
        String sql = "SELECT id_receiver FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            idReceiver = resultSet.getLong("id_receiver");
        }
        return idReceiver;
    }


    public Timestamp getEffectiveDateTransfer (String reference) throws SQLException{

        Date currentDate = new Date();
        Timestamp effectiveDate = new Timestamp(currentDate.getTime());

        String sql = "SELECT effective_date FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            effectiveDate = resultSet.getTimestamp("effective_date");
        }
        return effectiveDate;
    }


    public String getTransactionReference(String reference) throws SQLException{
        String ref = "00000000000000";
        String sql = "SELECT transaction_reference FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            ref = resultSet.getString("transaction_reference");
        }
        return ref;
    }


    public boolean getCanceledStatus(String reference) throws SQLException{
        boolean status = false;
        String sql = "SELECT is_canceled FROM outflow_transfer WHERE transaction_reference = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reference);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            status = resultSet.getBoolean("is_canceled");
        }
        return status;
    }



    /* UPDATE */

    public void setTransactionReference(String reference) throws SQLException{
        String sql = "UPDATE outflow_transfer SET transaction_reference = ? " +
                "WHERE transaction_reference = '00000000000000';";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, reference);
            statement.executeUpdate();
        }
    }


    public void setCanceleStatus(boolean status, String reference) throws SQLException{
        String sql = "UPDATE outflow_transfer SET is_canceled = ? " +
                "WHERER transaction_reference = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setBoolean(1, status);
            statement.setString(2, reference);

            statement.executeUpdate();
        }
    }

}

package com.prog4.FinalWallet.Repository;


import com.prog4.FinalWallet.Model.Account;
import com.prog4.FinalWallet.Model.Withdrawal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class WithdrawalRepository {
    private Connection connection;

    public Withdrawal createNewInstance (ResultSet resultSet) throws SQLException{
        return new Withdrawal(
                resultSet.getLong("id"),
                resultSet.getLong("id_account"),
                resultSet.getInt("withdrawal_amount"),
                resultSet.getTimestamp("withdrawal_drate")
        );
    }

    public List<Withdrawal> getWithdrawalHistory() throws SQLException {
        String sql = "SELECT * FROM withdrawal;";
        List<Withdrawal> list = new ArrayList<>();
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }


    public void doWithdraw(long id, int withdrawalAmount) throws SQLException{

        String sqlWithdrawal = "INSERT INTO withdrawal (id_account, withdrawal_amount) VALUES (?, ?);";
        String sqlAccount = "UPDATE account SET balance = balance - ? WHERE id = ?;";
        try {
            PreparedStatement withdrawStatement = connection.prepareStatement(sqlWithdrawal);
                withdrawStatement.setLong(1, id);
                withdrawStatement.setInt(2, withdrawalAmount);

                withdrawStatement.executeUpdate();

            PreparedStatement accountStatement = connection.prepareStatement(sqlAccount);
                accountStatement.setInt(1, withdrawalAmount);
                accountStatement.setLong(2, id);

                accountStatement.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("SQL request error", e);
        }
    }




}

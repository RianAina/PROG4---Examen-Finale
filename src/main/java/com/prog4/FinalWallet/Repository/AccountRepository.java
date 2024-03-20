package com.prog4.FinalWallet.Repository;

import com.prog4.FinalWallet.Model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;



@AllArgsConstructor
@Repository
public class AccountRepository {
    private Connection connection;

    public Account createNewInstance(ResultSet resultSet) throws SQLException{
        return new Account(
                resultSet.getLong("id"));
    }


    public List<Account> getAllId() throws SQLException {
        String sql = "SELECT * FROM test;";
        List<Account> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }


}
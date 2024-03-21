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
                resultSet.getLong("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getDate("birthDate"),
                resultSet.getInt("mensualSalary"));
    }


    public List<Account> getAllAccount() throws SQLException {
        String sql = "SELECT * FROM account;";
        List<Account> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public Account getAccountById(Long id) throws SQLException {
        String sql = "SELECT * FROM account WHERE id = ?;";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;
    }


    public void createAccount(Account account) throws SQLException {
        String sql = "INSERT INTO account (firstName, lastName, birthDate, mensualSalary) VALUES (?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setDate(3, account.getBirthDate());
            statement.setInt(4, account.getMensualSalary());

            statement.executeUpdate();
        }
    }


    public void updateAccount(Long id, Account account) throws SQLException {
        String sql = "UPDATE account SET mensualSalary = ? " +
                " WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, account.getMensualSalary());
            statement.setLong(2, id);

            statement.executeUpdate();
        }
    }


    public void deleteAccount(int id) throws SQLException {
        String sql = "DELETE FROM account WHERE id = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }}
package com.prog4.FinalWallet.Repository;

import com.prog4.FinalWallet.Model.Account;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;



@AllArgsConstructor
@Repository
public class AccountRepository {
    private Connection connection;
    private final JdbcTemplate jdbcTemplate;

    public Account createNewInstance(ResultSet resultSet) throws SQLException{
        return new Account(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getDate("birth_date"),
                resultSet.getInt("mensual_salary"),
                resultSet.getInt("balance"),
                resultSet.getBoolean("can_take_credit")
        );
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


    public int getAccountBalance(long id) throws SQLException{
        int balance = 0;
        String sql = "SELECT balance FROM account WHERE id = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            balance = resultSet.getInt("balance");
        }
        return balance;
    }


    public int getMensualSalary(long id) throws SQLException{
        int mensualSalary = 0;
        String sql = "SELECT mensual_salary FROM account WHERE id = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            mensualSalary = resultSet.getInt("balance");
        }
        return mensualSalary;
    }


    public boolean getCreditStatus(long id) throws SQLException{
        boolean creditStatus = false;
        String sql = "SELECT can_take_credit FROM account WHERE id = ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            creditStatus = resultSet.getBoolean("can_take_credit");
        }
        return creditStatus;
    }


    public void createAccount(Account account) throws SQLException {
        String sql = "INSERT INTO account (first_name, last_name, birth_date, mensual_salary, balance) " +
                "VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setDate(3, account.getBirthDate());
            statement.setInt(4, account.getMensualSalary());
            statement.setInt(5, account.getBalance());

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
    }




    public void setCreditStatus(Long id, Account account) throws SQLException{
        String sql = "UPDATE account SET can_take_credit = ? WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setBoolean(1, account.isCanTakeCredit());
            statement.setLong(2, id);
        }
    }




}
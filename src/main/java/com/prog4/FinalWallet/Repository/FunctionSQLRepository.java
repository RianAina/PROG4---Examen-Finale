package com.prog4.FinalWallet.Repository;

        import com.prog4.FinalWallet.Model.Account;
        import com.prog4.FinalWallet.Model.FunctionSQL;
        import com.prog4.FinalWallet.Model.IncomingTransfer;
        import lombok.AllArgsConstructor;
        import org.springframework.stereotype.Repository;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;


@AllArgsConstructor
@Repository
public class FunctionSQLRepository {
    private Connection connection;

    public FunctionSQL createNewInstance(ResultSet resultSet) throws SQLException {
        return new FunctionSQL (
                resultSet.getLong("id"),
                resultSet.getLong("id_account"),
                resultSet.getDouble("amount"),
                resultSet.getString("reason"),
                resultSet.getDate("effective_date"),
                resultSet.getDate("registration_date")
        );
    }


    public List<FunctionSQL> getAllAmount() throws SQLException {
        String sql = "SELECT * FROM all_amount('1999-01-01', '2030-03-31');";
        List<FunctionSQL> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public double getSumAmount() throws SQLException{
        double amount = 0;
        String sql = "SELECT * FROM visualize_expenses();";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            amount = resultSet.getDouble("balance");
        }
        return amount;
    }



}

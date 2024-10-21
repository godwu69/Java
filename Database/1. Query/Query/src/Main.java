import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

// CREATE PROCEDURE first

// CREATE PROCEDURE addCustomer(
//    IN Name longtext,
//    IN Password longtext,
//    IN Balance decimal(65,30)
//)
// BEGIN
//    INSERT INTO customers (Name, Password, Balance) VALUES (Name, Password, Balance);
// END;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://godwu69.mysql.database.azure.com:3306/ATMManagementDb";
        String user = "godwu69";
        String password = "Hoang123@#";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Loading...");
            CallableStatement stmt = connection.prepareCall("{call addCustomer(?, ?, ?)}");
            stmt.setString(1, "Dio Brando");
            stmt.setString(2, "password");
            stmt.setBigDecimal(3, new BigDecimal("3000.50"));
            stmt.execute();
            System.out.println("Customer added successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

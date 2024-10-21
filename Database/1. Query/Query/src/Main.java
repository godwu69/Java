import java.math.BigDecimal;
import java.sql.*;

// CREATE PROCEDURE addCustomer(
//    IN Name longtext,
//    IN Password longtext,
//    IN Balance decimal(65,30)
// )
// BEGIN
//    INSERT INTO customers (Name, Password, Balance) VALUES (Name, Password, Balance);
// END;


public class Main {
    public static void main(String[] args) {
        System.out.println("Connecting to database...");
        String url = "jdbc:mysql://godwu69.mysql.database.azure.com:3306/ATMManagementDb";
        String user = "godwu69";
        String password = "Hoang123@#";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database");
            System.out.println("Adding Customer...");
            CallableStatement stmt = connection.prepareCall("{CALL addCustomer(?, ?, ?)}");
            stmt.setString(1, "This is Name");
            stmt.setString(2, "password");
            stmt.setBigDecimal(3, new BigDecimal("3000.5"));
            stmt.execute();
            System.out.println("Customer added successfully.");
            stmt.close();

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM customers");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Customer list:");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                BigDecimal balance = rs.getBigDecimal(4);
                System.out.println("ID: " + id + ", Name: " + name + ", Password: " + pass + ", Balance: " + balance);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

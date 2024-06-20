
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ProductItem {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Manager", "root", "2003");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Product");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double pricePerUnit = resultSet.getDouble("price_per_unit");
                boolean activeForSell = resultSet.getBoolean("active_for_sell");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price per Unit: " + pricePerUnit);
                System.out.println("Active for Sell: " + activeForSell);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println();


        }

    }
}
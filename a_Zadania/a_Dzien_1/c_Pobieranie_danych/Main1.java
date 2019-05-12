package a_Zadania.a_Dzien_1.c_Pobieranie_danych;

import java.sql.*;

public class Main1 {

    public static String query = "select * from products";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             Statement stat = conn.createStatement()) {
            printAllProducts(stat.executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printAllProducts(ResultSet productsResult) throws SQLException {
        if (productsResult != null) {
            while (productsResult.next()) {
                String name = productsResult.getString("name");
                String description = productsResult.getString("description");
                if (description.length() > 20) {
                    description = description.substring(0, 19) + "...";
                }
                System.out.println(name + " " + description);
            }
        } else {
            System.out.println("Fail to get products");
        }
    }

}

package database_utils;

import java.sql.*;
import java.util.StringJoiner;

public class DatabaseUtils {

    private static String user = "root";
    private static String password = "coderslab";


    public static void executeQueryAndPrintResult(String databaseName, String query, String[] columnsToPrint) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                user, password);
             Statement stat = conn.createStatement()) {
            ResultSet resultSet = stat.executeQuery(query);
            while (resultSet.next()) {
                StringJoiner stringJoiner = new StringJoiner(" ");
                for (String columnName : columnsToPrint) {
                    stringJoiner.add(resultSet.getString(columnName));
                }
                System.out.println(stringJoiner.toString());
            }
        } catch (SQLException e) {
            System.out.println("Fail to get data for query: " + query);
            e.printStackTrace();
        }
    }
}

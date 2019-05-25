package database_utils;

import java.sql.*;
import java.util.StringJoiner;

public class DatabaseUtils {

    private static String user = "root";
    private static String password = "coderslab";
    private static String dbHost = "jdbc:mysql://localhost:3306/";
    private static String dbOptions = "?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public static void executeQueryAndPrintResult(String databaseName, String query, String[] columnsToPrint) {
        try (Connection conn = DriverManager.getConnection(
                dbHost + databaseName + dbOptions,
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

    public static void executeQueryAndPrintResultGroupedById(String databaseName, String query, String groupByMessage, String columnName) {
        try (Connection conn = DriverManager.getConnection(
                dbHost + databaseName + dbOptions,
                user, password);
             Statement stat = conn.createStatement()) {
            ResultSet resultSet = stat.executeQuery(query);
            int currentIndex = -1;
            while (resultSet.next()) {
                StringJoiner stringJoiner = new StringJoiner(" ");
                int newIndex = resultSet.getInt(1);
                if (currentIndex != newIndex) {
                    currentIndex = newIndex;
                    System.out.println(groupByMessage + currentIndex);
                }
                stringJoiner.add("");
                stringJoiner.add(resultSet.getString(columnName));
                System.out.println(stringJoiner.toString());
            }
        } catch (SQLException e) {
            System.out.println("Fail to get data for query: " + query);
            e.printStackTrace();
        }
    }
}

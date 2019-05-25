package database_utils;

import java.sql.*;
import java.util.StringJoiner;

public class DatabaseUtils {

    public static final String USER = "root";
    public static final String PASSWORD = "coderslab";
    public static final String DB_HOST = "jdbc:mysql://localhost:3306/";
    public static final String DB_OPTIONS = "?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void executeQueryAndPrintResult(String databaseName, String query, String[] columnsToPrint) {
        try (Connection conn = DriverManager.getConnection(
                DB_HOST + databaseName + DB_OPTIONS,
                USER, PASSWORD);
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

    public static void executeParametrizeQueryAndPrintResult(String databaseName, String query, String parameter, String[] columnsToPrint) {
        try (Connection conn = DriverManager.getConnection(
                DB_HOST + databaseName + DB_OPTIONS,
                USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, parameter);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean emptySet = true;
            while (resultSet.next()) {
                emptySet = false;
                StringJoiner stringJoiner = new StringJoiner(" ");
                for (String columnName : columnsToPrint) {
                    stringJoiner.add(resultSet.getString(columnName));
                }
                System.out.println(stringJoiner.toString());
            }
            if (emptySet) {
                System.out.println("Fail to find: " + parameter);
            }
        } catch (SQLException e) {
            System.out.println("Fail to get data for query: " + query);
            e.printStackTrace();
        }
    }

    public static void executeQueryAndPrintResultGroupedById(String databaseName, String query, String groupByMessage, String columnName) {
        try (Connection conn = DriverManager.getConnection(
                DB_HOST + databaseName + DB_OPTIONS,
                USER, PASSWORD);
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

    public static void executeQueryAndPrintResultGroupedById(String databaseName, String query, String groupByMessage, String groupColumn, String columnName) {
        try (Connection conn = DriverManager.getConnection(
                DB_HOST + databaseName + DB_OPTIONS,
                USER, PASSWORD);
             Statement stat = conn.createStatement()) {
            ResultSet resultSet = stat.executeQuery(query);
            int currentIndex = -1;
            while (resultSet.next()) {
                StringJoiner stringJoiner = new StringJoiner(" ");
                int newIndex = resultSet.getInt(1);
                if (currentIndex != newIndex) {
                    currentIndex = newIndex;
                    System.out.println(groupByMessage + resultSet.getString(groupColumn));
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

    public static void executeParametrizeQueryAndPrintResultGroupedById(String databaseName, String query,String parameter, String groupByMessage,String[] columnNames) {
        try (Connection conn = DriverManager.getConnection(
                DB_HOST + databaseName + DB_OPTIONS,
                USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, parameter);
            ResultSet resultSet = preparedStatement.executeQuery();
            int currentIndex = -1;
            while (resultSet.next()) {
                StringJoiner stringJoiner = new StringJoiner(" ");
                int newIndex = resultSet.getInt(1);
                if (currentIndex != newIndex) {
                    currentIndex = newIndex;
                    System.out.println(groupByMessage + currentIndex);
                }
                stringJoiner.add("");
                for (String columnName:columnNames) {
                    stringJoiner.add(resultSet.getString(columnName));
                }
                System.out.println(stringJoiner.toString());
            }
            if(currentIndex==-1){
                System.out.println("Fail to find: " + parameter);
            }
        } catch (SQLException e) {
            System.out.println("Fail to get data for query: " + query);
            e.printStackTrace();
        }
    }
}

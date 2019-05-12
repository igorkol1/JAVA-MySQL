package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main1 {

    public static String query = "create database products_ex";

    public static void main(String[] args) {
        establishConnection("products_ex");
    }

    protected static void establishConnection(String databaseName) {
        Connection conn = null;
        System.out.println("Start connecting...");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+databaseName+"?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "coderslab");
            System.out.println("Connection made.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Start closing connection...");
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Fail to close connection");
                }
            }
        }
    }
}


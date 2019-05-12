package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;

import java.sql.*;

import static a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych.Main1.getId;

public class Main2 {

    private static final String tickedQuery = "select id,price from tickets";
    private static final String updateQuantityQuery = "update tickets set quantity = (select (quantity+?) from (select * from tickets as temp) t where t.id = ?) where id = ?";

    public static void main(String[] args) {
        printTickets();
        int tickedTypeId = getTicketType();
        int tickedQuantity = getNumberOfTickets();
        addSoldTicked(tickedTypeId, tickedQuantity);
    }

    private static void printTickets() {
        System.out.println("Bilety: ");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             Statement stat = conn.createStatement()) {
            ResultSet movieResult = stat.executeQuery(tickedQuery);
            while (movieResult.next()) {
                System.out.println(movieResult.getString(1) + " " + movieResult.getDouble(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int getTicketType() {
        System.out.println("Podaj rodzaj biletu");
        return getId();
    }

    private static int getNumberOfTickets() {
        System.out.println("Podaj liczbe biletow");
        return getId();
    }

    private static void addSoldTicked(int tickedTypeId, int quantity) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             PreparedStatement preStmt = conn.prepareStatement(updateQuantityQuery)) {
            preStmt.setInt(1, quantity);
            preStmt.setInt(2, tickedTypeId);
            preStmt.setInt(3, tickedTypeId);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

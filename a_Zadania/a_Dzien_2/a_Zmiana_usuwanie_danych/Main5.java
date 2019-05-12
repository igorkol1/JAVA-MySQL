package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;

import java.sql.*;
import java.util.Scanner;

import static a_Zadania.a_Dzien_1.b_Dodawanie_danych.Main4.getCinemaData;
import static a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych.Main1.getId;

public class Main5 {

    private static final String dbUrl = "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String getCinemasQuery = "select id,name,address from cinemas";
    private static final String updateCinamaNameQuery = "update cinemas set name = ? where id = ?";
    private static final String updateCinamaAddressQuery = "update cinemas set address = ? where id = ?";
    private static final String deleteCinemaQuery = "delete from cinemas where id = ?";

    public static void main(String[] args) {
        printCinemas();
        char decision = getDecision();
        performOperation(decision);
    }

    private static void printCinemas() {
        System.out.println("Kina: ");
        try (Connection conn = DriverManager.getConnection(
                dbUrl,
                "root", "coderslab");
             Statement stat = conn.createStatement()) {
            ResultSet cinemaResult = stat.executeQuery(getCinemasQuery);
            while (cinemaResult.next()) {
                System.out.println(cinemaResult.getString(1) + " " + cinemaResult.getString(2) + " " + cinemaResult.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static char getDecision() {
        System.out.println("Chcesz dokonać edycji czy usunięcia: e/u (x->wyjscie z programu)");
        Scanner scan = new Scanner(System.in);
        boolean isDecisionMade = false;
        char decision;
        do {
            decision = scan.next().charAt(0);
            isDecisionMade = "eux".indexOf(decision) >= 0;
            if (!isDecisionMade) {
                System.out.println("Nieprawidłowa komenda. Możliwy wybor to e/u/x. Spróbuj jeszcze raz: ");
            }
        } while (!isDecisionMade);
        return decision;
    }

    private static void performOperation(char decision) {
        switch (decision) {
            case 'e':
                editCinema();
                break;
            case 'u':
                deleteCinema();
                break;
            case 'x':
                System.exit(0);
                break;
        }
    }

    private static int getCinemaId() {
        System.out.println("Podaj id kina");
        return getId();
    }

    private static void deleteCinema() {
        int cinemaId = getCinemaId();
        if (confirmDeleteDecision()) {
            try (Connection conn = DriverManager.getConnection(
                    dbUrl,
                    "root", "coderslab");
                 PreparedStatement preStmt = conn.prepareStatement(deleteCinemaQuery)) {
                preStmt.setInt(1, cinemaId);
                preStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            printCinemas();
        }
    }

    private static boolean confirmDeleteDecision() {
        System.out.println("Jesteś pewnień (t/n)");
        Scanner scan = new Scanner(System.in);
        boolean isDecisionMade = false;
        char decision;
        do {
            decision = scan.next().charAt(0);
            isDecisionMade = "tn".indexOf(decision) >= 0;
            if (!isDecisionMade) {
                System.out.println("Nieprawidłowa komenda. Możliwy wybor to t/n. Spróbuj jeszcze raz: ");
            }
        } while (!isDecisionMade);
        return decision == 't';
    }

    private static void editCinema() {
        int cinemaId = getCinemaId();
        String[] cinema = getCinemaData();
        try (Connection conn = DriverManager.getConnection(
                dbUrl,
                "root", "coderslab");
             PreparedStatement preStmtName = conn.prepareStatement(updateCinamaNameQuery);
             PreparedStatement preStmtAddress = conn.prepareStatement(updateCinamaAddressQuery)) {
            preStmtName.setString(1, cinema[0]);
            preStmtName.setInt(2, cinemaId);
            preStmtAddress.setString(1, cinema[1]);
            preStmtAddress.setInt(2, cinemaId);
            preStmtName.executeUpdate();
            preStmtAddress.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printCinemas();
    }

}

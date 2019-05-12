package a_Zadania.a_Dzien_1.b_Dodawanie_danych;

import java.sql.*;
import java.util.Scanner;


public class Main4 {
    public static void main(String[] args) {
        String[] cinema = getCinemaData();
        saveCinemaData(cinema);
        System.out.println("Stworzono nowe kino");
    }

    private static String[] getCinemaData() {
        String[] cinemaData = new String[2];
        System.out.println("Podaj nazwe kina");
        cinemaData[0] = readDataFromConsole(20);
        System.out.println("Podaj adres");
        cinemaData[1] = readDataFromConsole(300);
        return cinemaData;
    }

    private static void saveCinemaData(String[] cinema) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             PreparedStatement preStmt = conn.prepareStatement("insert into cinemas(name, address) VALUE (?,?)")) {
            preStmt.setString(1, cinema[0]);
            preStmt.setString(2, cinema[1]);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String readDataFromConsole(int limit) {
        Scanner scan = new Scanner(System.in);
        String temp;
        boolean isDataCorrect;
        do {
            temp = scan.nextLine();
            isDataCorrect = temp.length() < limit;
            if (!isDataCorrect) {
                System.out.println("Nieprawidłowe dane. Podaj jeszcze raz");
            }

        } while (!isDataCorrect);
        return temp;
    }

}

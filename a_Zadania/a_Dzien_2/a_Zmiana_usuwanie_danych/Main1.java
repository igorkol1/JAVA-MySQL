package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;

import java.sql.*;
import java.util.Scanner;

public class Main1 {

    private static final String getMoviesIDAndTitleQuery = "select id,title from movies";
    private static final String deleteMovieQuery = "DELETE FROM movies WHERE id = ?";

    public static void main(String[] args) {
        printMovies();
        int id = getMovieId();
        System.out.println("Delete movie with id: " + id);
        deleteMovie(id);

    }

    private static void printMovies() {
        System.out.println("Filmy: ");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             Statement stat = conn.createStatement()) {
            ResultSet movieResult = stat.executeQuery(getMoviesIDAndTitleQuery);
            while (movieResult.next()) {
                System.out.println(movieResult.getString(1) + " " + movieResult.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int getMovieId() {
        System.out.println("Podaj id filmu: ");
        return getId();
    }

    protected static int getId() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("Nieprawidłowe dane. Podaj jeszcze raz: ");
        }
        return scan.nextInt();
    }

    private static void deleteMovie(int id) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             PreparedStatement preStmt = conn.prepareStatement(deleteMovieQuery)) {
            preStmt.setInt(1, id);
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

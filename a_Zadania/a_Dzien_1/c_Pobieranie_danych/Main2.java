package a_Zadania.a_Dzien_1.c_Pobieranie_danych;

import java.sql.*;

public class Main2 {

    private static final String query = "select title from movies where rating>(SELECT AVG(rating) FROM movies)";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             Statement stat = conn.createStatement()) {
            printTitles(stat.executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printTitles(ResultSet moviesResult) throws SQLException {
        while (moviesResult.next()) {
            System.out.println(moviesResult.getString(1));
        }
    }

}

package b_Zadania_domowe.a_Dzien_2;

import java.sql.*;
import java.util.StringJoiner;

import static database_utils.DatabaseUtils.*;

public class Main4 {

    public static void main(String[] args) {
        printMoviesWithCinemas();
    }

    public static void printMoviesWithCinemas() {
        String query = "select m.id,m.title,m.description,m.rating,c.name from cinemas_movies join movies m on cinemas_movies.movie_id = m.id join cinemas c on cinemas_movies.cinema_id = c.id order by m.id;";
        try (Connection conn = DriverManager.getConnection(
                DB_HOST + "cinemas_ex" + DB_OPTIONS,
                USER, PASSWORD);
             Statement stat = conn.createStatement()) {
            ResultSet resultSet = stat.executeQuery(query);
            int currentIndex = -1;
            while (resultSet.next()) {
                StringJoiner stringJoiner = new StringJoiner(" ");
                int newIndex = resultSet.getInt(1);
                if (currentIndex != newIndex) {
                    StringJoiner headerJoiner = new StringJoiner(" ");
                    currentIndex = newIndex;
                    headerJoiner.add(resultSet.getString("title"));
                    headerJoiner.add(resultSet.getString("description"));
                    headerJoiner.add(resultSet.getString("rating"));
                    System.out.println(headerJoiner.toString());
                }
                stringJoiner.add("");
                stringJoiner.add(resultSet.getString("name"));
                System.out.println(stringJoiner.toString());
            }
        } catch (SQLException e) {
            System.out.println("Fail to get data for query: " + query);
            e.printStackTrace();
        }
    }

}

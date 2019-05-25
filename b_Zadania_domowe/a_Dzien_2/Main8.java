package b_Zadania_domowe.a_Dzien_2;


import database_utils.DatabaseUtils;

import java.sql.*;

import static b_Zadania_domowe.a_Dzien_2.Main7.getCinemaParameter;
import static b_Zadania_domowe.a_Dzien_2.Main7.getMoviesForCinema;

public class Main8 {

    private static final String dbUrl = "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {
        DatabaseUtils.executeQueryAndPrintResult("cinemas_ex","select id,name from cinemas;",new String[]{"id","name"});
        System.out.println("");
        String cinema = getCinemaParameter();
        getMoviesForCinema(cinema);
        System.out.println("");
        String movie = getCinemaParameter();
        printScreenings(cinema,movie);

    }

    private static void printScreenings(String cinema,String movie){
        String query = "select show_time from screenings where movie_id = ? and cinema_id = ?";
        try (Connection conn = DriverManager.getConnection(
                dbUrl,
                "root", "coderslab");
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, movie);
            preparedStatement.setString(2,cinema);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }else {
                System.out.println("Brak seansow");
            }
        } catch (SQLException e) {
            System.out.println("Fail to get data for query: " + query);
            e.printStackTrace();
        }
    }
}

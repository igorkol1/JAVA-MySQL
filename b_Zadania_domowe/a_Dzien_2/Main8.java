package b_Zadania_domowe.a_Dzien_2;


import database_utils.DatabaseUtils;

import java.sql.*;

import static b_Zadania_domowe.a_Dzien_2.Main7.*;
import static database_utils.DatabaseUtils.*;
import static database_utils.DatabaseUtils.DB_OPTIONS;

public class Main8 {

    public static void main(String[] args) {
        DatabaseUtils.executeQueryAndPrintResult("cinemas_ex","select id,name from cinemas;",new String[]{"id","name"});
        System.out.println("");
        String cinema = getParameter("Podaj Id kina: ");
        getMoviesForCinema(cinema);
        System.out.println("");
        String movie = getParameter("Podaj id filmu: ");
        System.out.println("");
        System.out.println("Seanse: ");
        printScreenings(cinema,movie);
    }

    private static void printScreenings(String cinema,String movie){
        String query = "select show_time from screenings where movie_id = ? and cinema_id = ?";
        try (Connection conn = DriverManager.getConnection(
                DB_HOST + "cinemas_ex" + DB_OPTIONS,
                USER, PASSWORD);
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

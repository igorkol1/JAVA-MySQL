package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import database_utils.DatabaseUtils;

public class Main5 {

    public static String query1 = "select c.id as cinema,m.id as movie from cinemas_movies join cinemas c on cinemas_movies.cinema_id = c.id join movies m on cinemas_movies.movie_id = m.id order by c.id;";

    public static void main(String[] args) {
        DatabaseUtils.executeQueryAndPrintResultGroupedById("cinemas_ex", query1, "Kino o id ", "movie");
    }
}

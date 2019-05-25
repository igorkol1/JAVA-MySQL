package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import database_utils.DatabaseUtils;

public class Main4 {
    public static void main(String[] args) {
        String query = "select m.id as movie,c.id as cinema from cinemas_movies join cinemas c on cinemas_movies.cinema_id = c.id join movies m on cinemas_movies.movie_id = m.id order by m.id;";
        DatabaseUtils.executeQueryAndPrintResultGroupedById("cinemas_ex", query, "Film o id ", "cinema");
    }
}

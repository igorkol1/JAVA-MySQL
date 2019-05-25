package b_Zadania_domowe.a_Dzien_2;


import database_utils.DatabaseUtils;

public class Main4 {

    public static void main(String[] args) {
        String query = "select m.id,m.title,m.description,c.name from cinemas_movies join movies m on cinemas_movies.movie_id = m.id join cinemas c on cinemas_movies.cinema_id = c.id order by m.id;";
        DatabaseUtils.executeQueryAndPrintResultGroupedById("cinemas_ex",query,"Film: ","title","name");
    }

}

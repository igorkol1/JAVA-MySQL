package b_Zadania_domowe.a_Dzien_2;


import database_utils.DatabaseUtils;

public class Main5 {
    public static void main(String[] args) {
        System.out.println("List kin:");
        DatabaseUtils.executeQueryAndPrintResult("cinemas_ex","select name from cinemas;",new String[]{"name"});
        System.out.println("");
        String query1 = "select c.id,c.name,m.title from cinemas_movies join movies m on cinemas_movies.movie_id = m.id join cinemas c on cinemas_movies.cinema_id = c.id order by c.id;";
        System.out.println("List filmów per kino");
        DatabaseUtils.executeQueryAndPrintResultGroupedById("cinemas_ex",query1,"Kino o nazwie: ","name","title");
        System.out.println("");
        String query2 = "select m.id,m.title,show_time from screenings join movies m on screenings.movie_id = m.id order by m.id;";
        System.out.println("Lista seansów");
        DatabaseUtils.executeQueryAndPrintResultGroupedById("cinemas_ex",query2,"Seanse filmu: ","title","show_time");
    }

}

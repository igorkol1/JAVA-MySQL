package b_Zadania_domowe.a_Dzien_2;


import database_utils.DatabaseUtils;

import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        DatabaseUtils.executeQueryAndPrintResult("cinemas_ex","select id,name from cinemas;",new String[]{"id","name"});
        System.out.println("");
        String cinemaName = getParameter("Podaj id kina: ");
        getMoviesForCinema(cinemaName);
    }

    protected static String getParameter(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    protected static void getMoviesForCinema(String cinemaName){
        String query = "select c.id,c.name,m.id as movie_id,m.title from cinemas_movies join cinemas c on cinemas_movies.cinema_id = c.id join movies m on cinemas_movies.movie_id = m.id where c.id =?";
        DatabaseUtils.executeParametrizeQueryAndPrintResultGroupedById("cinemas_ex",query,cinemaName,"Kino o id: ",new String[]{"movie_id","title"});
    }

}

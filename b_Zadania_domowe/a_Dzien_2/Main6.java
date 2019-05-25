package b_Zadania_domowe.a_Dzien_2;


import database_utils.DatabaseUtils;

import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        String title = getTitle();
        showMovieDetails(title);
    }

    private static String getTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe filmu");
        return scanner.nextLine();
    }

    private static void showMovieDetails(String title) {
        DatabaseUtils.executeParametrizeQueryAndPrintResult("cinemas_ex", "select * from movies where title=?", title, new String[]{"title", "description", "rating"});
    }
}

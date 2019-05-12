package a_Zadania.a_Dzien_1.c_Pobieranie_danych;


public class Main3 {
    public static String query1 = "select title from movies where title like 'W%' or title like 'w%'";
    public static String query2 = "select id,price from tickets where price>15.30";
    public static String query3 = "select id,quantity from tickets where quantity>3";
    public static String query4 = "select title, rating from movies where rating>6.5";
    public static String query5 = "select title,rating from movies ORDER BY rating desc limit 1";
}

package a_Zadania.a_Dzien_1.c_Pobieranie_danych;


public class Main4 {
    public static String query1 = "select SUM(quantity) from tickets";
    public static String query2 = "select type, COUNT(*) from payments group by type";
    public static String query3 = "select avg(price) from tickets";
    public static String query4 = "select * from payments order by payment_date limit 5 offset 2";
    public static String query5 = "select type, COUNT(*) as quantity from payments group by type having quantity>=2";
    public static String query6 = "select COALESCE(SUM(quantity),0) as SUM from tickets where price>23.15";
}

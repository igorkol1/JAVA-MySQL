package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;


public class Main4 {
    public String query1 = "update cinemas set address = 'Stadion Narodowy' where name like '%z'";
    public String query2 = "delete from payments where payment_date<(NOW()-4)";
    public String query3 = "update movies set rating = 5.4 where LENGTH(description)>40";
    public String query4 = "update tickets set price = (select (0.5*price) from (select * from tickets as temp) t where t.quantity>10) where quantity>10";
}

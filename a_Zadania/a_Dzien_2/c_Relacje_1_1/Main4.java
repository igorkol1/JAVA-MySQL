package a_Zadania.a_Dzien_2.c_Relacje_1_1;


public class Main4 {
    public String query1 = "select t.id,quantity,payment_date,type,isPaid from tickets t join payments p on t.id = p.id where p.type='cash';";
    public String query2 = "select t.id,quantity,payment_date,type,isPaid from tickets t join payments p on t.id = p.id where p.type='transfer';";
    public String query3 = "select t.id,quantity,payment_date,type,isPaid from tickets t join payments p on t.id = p.id where p.type='card';";
    public String query4 = "select t.id,quantity,payment_date,type,isPaid from tickets t left join payments p on t.id = p.id where p.isPaid='false' OR p.isPaid is null;";

}

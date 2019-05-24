package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


import database_utils.DatabaseUtils;

public class Main4 {
    public static String query1 = "select * from categories_sub where main_id=1;";
    public static String query2 = "select distinct c.id,c.name from categories_sub s join categories c on s.main_id = c.id;";

    public static void main(String[] args) {
        System.out.println("Query 1");
        DatabaseUtils.executeQueryAndPrintResult("products_ex", query1, new String[]{"name"});
        System.out.println("Query 2");
        DatabaseUtils.executeQueryAndPrintResult("products_ex", query2, new String[]{"id", "name"});
    }

}

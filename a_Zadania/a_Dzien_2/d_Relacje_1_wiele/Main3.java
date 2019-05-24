package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


import database_utils.DatabaseUtils;

public class Main3 {
    public static String query1 = "select p.id,p.name,o.description from products p join opinions o on p.id = o.product_id;";
    public static String query2 = "select p.id,p.name,o.description from products p left join opinions o on p.id = o.product_id;";
    public static String query3 = "select o.description as opinion,o.product_id,p.name,p.description,p.price from opinions o join products p on o.product_id = p.id;";

    public static void main(String[] args) {
        System.out.println("Query 1");
        DatabaseUtils.executeQueryAndPrintResult("products_ex", query1, new String[]{"id", "name", "description"});
        System.out.println("Query 2");
        DatabaseUtils.executeQueryAndPrintResult("products_ex", query2, new String[]{"id", "name", "description"});
        System.out.println("Query 3");
        DatabaseUtils.executeQueryAndPrintResult("products_ex", query3, new String[]{"opinion", "product_id", "name", "description", "price"});
    }

}

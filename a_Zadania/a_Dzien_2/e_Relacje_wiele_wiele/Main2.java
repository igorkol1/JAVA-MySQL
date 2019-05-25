package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import database_utils.DatabaseUtils;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Wszystkie zamowienia");
        DatabaseUtils.executeQueryAndPrintResult("products_ex", "select * from products;", new String[]{"id", "name"});
        System.out.println("");
        System.out.println("Zamowienie pogrupowane");
        String query = "select i.item_id,o.description from items_orders join items i on items_orders.item_id = i.item_id join orders o on items_orders.order_id = o.id order by i.item_id;";
        DatabaseUtils.executeQueryAndPrintResultGroupedById("products_ex", query, "Produkt o id ", "description");
    }
}

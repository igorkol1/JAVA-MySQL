package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import database_utils.DatabaseUtils;

public class Main1 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
    public String query1 = "CREATE TABLE items_orders(id int AUTO_INCREMENT,item_id int NOT NULL,order_id int NOT NULL,PRIMARY KEY(id),FOREIGN KEY(order_id) REFERENCES orders(id),FOREIGN KEY(item_id) REFERENCES items(item_id));";

    //zapytania łączące produkty z zamówieniami
    public String query2 = "INSERT INTO items_orders(order_id, item_id) VALUES (1,1);";
    public String query3 = "INSERT INTO items_orders(order_id, item_id) VALUES (1,2);";
    public String query4 = "INSERT INTO items_orders(order_id, item_id) VALUES (1,3);";
    public String query5 = "INSERT INTO items_orders(order_id, item_id) VALUES (2,1);";

    public static String query6 = "select order_id,o.description,i.name from items_orders join items i on items_orders.item_id = i.item_id join orders o on items_orders.order_id = o.id;";

    public static void main(String[] args) {
        System.out.println("Wszystkie zamowienia");
        DatabaseUtils.executeQueryAndPrintResult("products_ex", "select * from orders;", new String[]{"description"});

        System.out.println("Zamowienie pogrupowane");
        DatabaseUtils.executeQueryAndPrintResultGroupedById("products_ex", query6, "Zamówienie id: ", "name");

    }
}

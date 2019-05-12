package a_Zadania.a_Dzien_1.b_Dodawanie_danych;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

    /*
    select * from products;

    insert into products(name, description, price) VALUE ("Chleb","Chleb razowy",2.50);

    insert into products(name, description, price) VALUE ("Masło","Delma",5);

    select * from orders;

    insert into orders(description) value ('Zakupy do szkoły');

    insert into orders(description) value ('Zakupy do pracy');

    select * from clients;

    insert into clients(name, surname) VALUE ('Igor','Kołodziejczyk');

    insert into clients(name, surname) VALUE ('Jan','Kowalski');

     */

    public static void main(String[] args) {
        executeStatement("products_ex", "insert into products(name, description, price) VALUE (\"Chleb\",\"Chleb razowy\",2.50);");
    }

    protected static void executeStatement(String databaseName, String query) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false&characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "coderslab");
             Statement stat = conn.createStatement()) {
            stat.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

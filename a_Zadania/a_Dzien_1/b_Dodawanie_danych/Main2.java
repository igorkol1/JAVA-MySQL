package a_Zadania.a_Dzien_1.b_Dodawanie_danych;

import static a_Zadania.a_Dzien_1.b_Dodawanie_danych.Main1.executeStatement;

public class Main2 {

    public String query1 = "INSERT INTO products SET id=0, name=produkt1, description=name, price=904";
    public static String query1fixed = "INSERT INTO products SET id=0, name='produkt1', description='name', price=904";

    public String query2 = "INSERT INTO clients VALUES(\"Jan\", \"Kowalski\", 4, \"Mr.\")";
    public static String query2fixed = "INSERT INTO clients(name,surname) VALUES('Jan', 'Kowalski')";

    public String query3 = "INSERT INTO movies(id, rating, title) VALUES(null, \"bardzo dobry\", \"Szybcy i wściekli\")";
    public static String query3fixed = "INSERT INTO movies(rating, title) VALUES(5, 'Szybcy i wściekli')";

    public String query4 = "INSERT INTO payments SET id=90 AND VALUES(\"cash\", NOW())";
    public static String query4fixed = "INSERT INTO payments(type, payment_date) VALUES('cash', NOW());";

    public static void main(String[] args) {
        executeStatement("cinemas_ex", query4fixed);
    }
}

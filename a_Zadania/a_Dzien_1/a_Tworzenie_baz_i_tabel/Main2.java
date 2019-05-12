package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

/*
create database products_ex;

        create table products
        (
        id          int AUTO_INCREMENT,
        name        varchar(20),
        description varchar(300),
        price       decimal(6, 2),
        PRIMARY KEY (id)
        );

        create table orders
        (
        id          int UNIQUE AUTO_INCREMENT,
        description varchar(300)
        );

        create table clients
        (
        id      int UNIQUE AUTO_INCREMENT,
        name    varchar(20),
        surname varchar(20)
        )
*/

public class Main2 {

    public static String queryCreateTableProducts =
            "create table products\n" +
                    "(\n" +
                    "    id          int AUTO_INCREMENT,\n" +
                    "    name        varchar(20),\n" +
                    "    description varchar(300),\n" +
                    "    price       decimal(6, 2),\n" +
                    "    PRIMARY KEY (id)\n" +
                    ");";

    public static String queryCreateTableOrders =
            "create table orders\n" +
                    "(\n" +
                    "    id          int UNIQUE,\n" +
                    "    description varchar(300)\n" +
                    ");";

    public static String queryCreateTableClients =
            "create table clients\n" +
                    "(\n" +
                    "    id      int UNIQUE,\n" +
                    "    name    varchar(20),\n" +
                    "    surname varchar(20)\n" +
                    ")";
}

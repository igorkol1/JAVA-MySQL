package a_Zadania.a_Dzien_2.c_Relacje_1_1;


public class Main1 {

    public String tableAddQuery = "CREATE TABLE client_address (\n" +
            "    client_id int NOT NULL,\n" +
            "    city varchar(80),\n" +
            "    street varchar(100),\n" +
            "    house_nr varchar(10),\n" +
            "    PRIMARY KEY(client_id),\n" +
            "    FOREIGN KEY(client_id) REFERENCES clients(id) ON DELETE CASCADE\n" +
            "     );";

    public String tableAddRow1 = "insert into client_address(client_id, city, street, house_nr) VALUES (1,'Warszawa','Kowalska','3');";
    public String tableAddRow2 = "insert into client_address(client_id, city, street, house_nr) VALUES (2,'Warszawa','JP 2','33');";
    public String tableAddRow3 = "insert into client_address(client_id, city, street, house_nr) VALUES (3,'Warszawa','Grochowska','115A');";
    public String tableAddRow4 = "insert into client_address(client_id, city, street, house_nr) VALUES (4,'Warszawa','Olgierta','1B');";
    public String tableAddRow5 = "insert into client_address(client_id, city, street, house_nr) VALUES (5,'Warszawa','Domaniewska','98');";
}

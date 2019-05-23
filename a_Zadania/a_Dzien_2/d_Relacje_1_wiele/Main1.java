package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


public class Main1 {

    //create table opinions(id int AUTO_INCREMENT PRIMARY KEY,description varchar(500),product_id int NOT NULL , FOREIGN KEY(product_id) REFERENCES products(id));

    public String queryProduct1Opinion1 = "insert into opinions(description, product_id) VALUES ('Dobry bo razowy',1);";
    public String queryProduct1Opinion2 = "insert into opinions(description, product_id) VALUES ('Nie dobry bo razowy',1);";
    public String queryProduct1Opinion3 = "insert into opinions(description, product_id) VALUES ('Nie dobry bo suchy',1);";
    public String queryProduct1Opinion4 = "insert into opinions(description, product_id) VALUES ('Dobry bo suchy',1);";
    public String queryProduct1Opinion5 = "insert into opinions(description, product_id) VALUES ('Nie dobry bo czerstwy',1);";

    public String queryProduct2Opinion1 = "insert into opinions(description, product_id) VALUES ('Dobra bo tania',2);";
    public String queryProduct2Opinion2 = "insert into opinions(description, product_id) VALUES ('Moze byc',2);";
    public String queryProduct2Opinion3 = "insert into opinions(description, product_id) VALUES ('Rozpuszcona',2);";
    public String queryProduct2Opinion4 = "insert into opinions(description, product_id) VALUES ('Nie dobra bo bez samku',2);";
    public String queryProduct2Opinion5 = "insert into opinions(description, product_id) VALUES ('Nie dobra bo tlusta',2);";

    public String queryProduct3Opinion1 = "insert into opinions(description, product_id) VALUES ('Test 1',3);";
    public String queryProduct3Opinion2 = "insert into opinions(description, product_id) VALUES ('Test 2',3);";
    public String queryProduct3Opinion3 = "insert into opinions(description, product_id) VALUES ('Test 3',3);";
    public String queryProduct3Opinion4 = "insert into opinions(description, product_id) VALUES ('Test 4',3);";
    public String queryProduct3Opinion5 = "insert into opinions(description, product_id) VALUES ('Test 5',3);";
}

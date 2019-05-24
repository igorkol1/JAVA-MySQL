package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


public class Main2 {

    public String queryAddCategories = "create table categories(id int NOT NULL AUTO_INCREMENT PRIMARY KEY,name varchar(100) NOT NULL);";

    public String queryAddCategoriesSub = "create table categories_sub(id int NOT NULL AUTO_INCREMENT PRIMARY KEY,main_id int NOT NULL,name varchar(100) NOT NULL, FOREIGN KEY(main_id) REFERENCES categories(id));";

}

package b_Zadania_domowe.a_Dzien_2;


public class Main2 {

    public String queryRelationImages = "alter table images add foreign key(offer_id) references offers(id);";

    private String dropAutoIncrement = "ALTER table users_companies modify column id int; ";
    private String changePrimaryKey = "ALTER TABLE users_companies DROP PRIMARY KEY, ADD PRIMARY KEY (user_id); ";
    private String addNewRelation = "alter table users_companies add foreign key(user_id) references users(id); ";
    private String dropOldIdColumn = "alter table users_companies drop column id; ";

    public String queryRelationUsersCompanies = dropAutoIncrement+changePrimaryKey+addNewRelation+dropOldIdColumn;
}

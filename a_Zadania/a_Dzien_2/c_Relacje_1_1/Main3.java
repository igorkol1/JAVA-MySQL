package a_Zadania.a_Dzien_2.c_Relacje_1_1;


public class Main3 {

    public String queryCreateTable = "CREATE TABLE payments (\n" +
            "    id int NOT NULL,\n" +
            "    type varchar(80),\n" +
            "    payment_date date,\n" +
            "    isPaid boolean,\n" +
            "    PRIMARY KEY(id),\n" +
            "    FOREIGN KEY(id) REFERENCES tickets(id) ON DELETE CASCADE\n" +
            "     );";


//    alter table payments modify column isPaid int DEFAULT false;
//
//    select * from payments;
//
//    insert into payments(id, type, payment_date, isPaid) VALUES (1,'cash',CURDATE(),true);
//
//    insert into payments(id, type, payment_date, isPaid) VALUES (2,'cash',CURDATE(),true);
//
//    insert into payments(id, type, payment_date, isPaid) VALUES (3,'cash',CURDATE(),true);
//
//    insert into payments(id, type, payment_date) VALUES (4,'transfer',CURDATE());
//
//    insert into payments(id, type, payment_date) VALUES (5,'transfer',CURDATE());
//
//    insert into payments(id, type, payment_date) VALUES (6,'transfer',CURDATE());
//
//    insert into payments(id, type, payment_date) VALUES (7,'card',CURDATE(),true);
//
//    insert into payments(id, type, payment_date) VALUES (8,'card',CURDATE(),false);
//
//    insert into payments(id, type, payment_date) VALUES (9,'card',CURDATE(),true);
}

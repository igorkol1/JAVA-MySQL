package b_Zadania_domowe.a_Dzien_2;


public class Main3 {
    private String newTableQuery = "create table screenings(id int AUTO_INCREMENT PRIMARY KEY,cinema_id int(11) NOT NULL, movie_id int(11) NOT NULL,show_time DATETIME,FOREIGN KEY(cinema_id) REFERENCES cinemas(id),FOREIGN KEY(movie_id) REFERENCES movies(id));";

    /*
    insert into screenings(cinema_id, movie_id, show_time) VALUES (1,1,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (1,2,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (1,3,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (1,4,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (1,5,NOW());

    insert into screenings(cinema_id, movie_id, show_time) VALUES (2,1,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (2,6,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (2,7,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (2,4,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (2,5,NOW());

    insert into screenings(cinema_id, movie_id, show_time) VALUES (3,1,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (3,8,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (3,9,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (3,10,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (3,5,NOW());

    insert into screenings(cinema_id, movie_id, show_time) VALUES (4,1,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (4,2,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (4,3,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (4,11,NOW());
    insert into screenings(cinema_id, movie_id, show_time) VALUES (4,12,NOW());

     */

}

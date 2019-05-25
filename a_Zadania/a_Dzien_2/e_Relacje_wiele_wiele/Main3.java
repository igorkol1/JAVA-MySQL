package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


public class Main3 {
    public String query1 = "create table cinemas_movies(id int AUTO_INCREMENT,cinema_id int NOT NULL, movie_id int NOT NULL,PRIMARY KEY (id),FOREIGN KEY(cinema_id) REFERENCES cinemas(id),FOREIGN KEY(movie_id) REFERENCES movies(id));";

    //insert into cinemas_movies(cinema_id, movie_id) VALUES (1,1),(1,2),(1,3),(2,4),(2,2),(2,3),(2,1),(3,3),(3,1),(3,5);

}

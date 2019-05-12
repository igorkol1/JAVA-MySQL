package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import static a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel.Main1.establishConnection;

public class Main3 {
    //Zapisz w poniższej zmiennej kod zapytania SQL
    public static String query = "create database cinemas_ex;";

    public static void main(String[] args) {
        establishConnection("cinemas_ex");
    }

}

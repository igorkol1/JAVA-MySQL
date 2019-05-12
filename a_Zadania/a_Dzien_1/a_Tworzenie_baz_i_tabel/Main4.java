package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

public class Main4 {
//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego pierwszą tabelę
	public static String queryCreateTableCinemas = "";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego drugą tabelę
	public static String queryCreateTableMovies = "";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego trzecią tabelę
	public static String queryCreateTableTickets = "";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego czwartą tabelę
	public static String queryCreateTablePayments = "";
/*
	create table cinemas
			(
					id      int AUTO_INCREMENT UNIQUE,
					name    varchar(20),
	address varchar(300)
	);

	create table movies
			(
					id          int UNIQUE AUTO_INCREMENT,
					title       varchar(70),
	description varchar(300),
	rating      decimal(2, 2)
	);

	create table tickets
			(
					id       int UNIQUE AUTO_INCREMENT,
					quantity int,
					price    decimal(2, 2)
	);

	create table payments
			(
					id           int UNIQUE AUTO_INCREMENT,
					type         varchar(8),
	payment_date date
	);
*/

}

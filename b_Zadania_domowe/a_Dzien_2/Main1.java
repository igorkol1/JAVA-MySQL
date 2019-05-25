package b_Zadania_domowe.a_Dzien_2;


public class Main1 {

    public String query1 = "update offers set price=price+1000 where owner between 20 and 25;";

    public String query2 = "delete from offers where expire<=DATE_ADD(NOW(),INTERVAL -3 DAY );";

    public String query3 = "delete from offers where phone like '+48%' and promoted=1 and expire>NOW() and status=1;";

    //SUBSTRING(REPLACE(REPLACE(REPLACE(REPLACE(phone,' ',''),'+',''),'(',''),')',''),3,1) = 4 and SUBSTRING(REPLACE(REPLACE(REPLACE(REPLACE(phone,' ',''),'+',''),'(',''),')',''),3,1) = 8 and promoted=0
    public String query4 = "update offers set promoted=1 and promoted_to=date_add(now(),interval 23 day) where substring(phone,3,1)=4 and substring(phone,4,1)=8 and promoted = 0;";

    public String query5 = "update offers set description=REPLACE(description,'executed','found') where price>400000 and (phone like '%(%' or phone like '%)%');";

}

package b_Zadania_domowe.a_Dzien_1;


public class Main1 {
    public String query1 = "select * from demoDb.users where name like 'Julia%';";

    public String query2 = "select * from users order by email desc limit 5;";

    public String query3 = "select * from users where email like '%@yahoo.com' and name like 'L%';";

    public String query4 = "select * from users where PASSWORD=SHA2(CONCAT(name,salt),256);";

    public String query5 = "select id,title from offers where price>500000;";

    public String query6 = "select id,price from offers where activation_token='' and price BETWEEN 2000 and 400000;";

    public String query7 = "select title,price,phone from offers where status=true and expire<=DATE_ADD(NOW(),INTERVAL 10 DAY);";

    public String query8 = "select * from offers where description like '%violent%' and phone like '%2%' and price>50000;";

    public String query9 = "select * from offers where promoted=0 and price<300000 and title like '%LCC';";

    public String query10 = "select * from offers where 2*price<50000 and promoted = 1 and promoted_to>NOW();";

    public String query11 = "select count(*) as sum_active from offers where expire>NOW() and status=1;";

    public String query12 = "select owner,count(*) as sum_user from offers where expire>NOW() and status=1 group by owner;";

    public String query13 = "select status as type,count(*) as counter from offers where status=1 or status=2 group by status;";

    public String query14 = "select SUM(price) as sum_nonactive_nopromoted from offers where expire<NOW() and status=1 and promoted=0";

    public String query15 = "select ROUND(AVG(price),2) as avg_price from offers where status=1 and expire>now() and promoted=1 and price>44645.04;";

}

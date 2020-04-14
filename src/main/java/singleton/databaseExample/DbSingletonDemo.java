package singleton.databaseExample;

import singleton.RuntimeExample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {
    public static void main(String[] args){
        RuntimeExample runtimeExample = new RuntimeExample();
        runtimeExample.testRuntimeSingleton();

        DbSingleton instance = DbSingleton.getInstance();
        DbSingleton instance1 = DbSingleton.getInstance();
        if (instance == instance1)
        {
            System.out.println("instances are same");
        }

        long timeBefore =0;
        long timeAfter = 0;
        timeBefore = System.currentTimeMillis();
        Connection conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println(timeAfter-timeBefore);

        Statement sta;
        try{
            sta = conn.createStatement();
            int count = sta.executeUpdate("create table Address (ID int ,StreatName varchar(20))"+"City varchar(20)");
            System.out.println("table created");
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        timeBefore = System.currentTimeMillis();
        conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();
        try{
            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("select * from Address");
            System.out.println(rs);
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

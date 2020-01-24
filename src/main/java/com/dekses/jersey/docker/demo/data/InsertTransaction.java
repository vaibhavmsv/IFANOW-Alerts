package com.dekses.jersey.docker.demo.data;

import com.dekses.jersey.docker.demo.model.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTransaction {

    private String insertQuery = "INSERT INTO sys.Event (userid, noun, ts, time, location, verb, properties)\n" +
            "VALUES";
    private String insertUserQuery = "INSERT INTO sys.user (userid)\n" +
            "VALUES";

    public void insertEvent(Event event) {
        try{
            String remainingInsertQuery = " ("+event.getUserId()+", '"+event.getNoun()+"', "+event.getTimeSpent()+", '"+event.getEventTime()+"', "+event.getEventLocLongitude()+", '"+event.getPay()+"', '"+event.getProperties().toString()+"');";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys","root","root");
            Statement stmt=con.createStatement();
            int rs=stmt.executeUpdate(insertQuery+remainingInsertQuery);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void insertUserData(Event event) {
        try{
            String remainingInsertQuery = " ("+event.getUserId()+");";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys","root","root");
            Statement stmt=con.createStatement();
            int rs=stmt.executeUpdate(insertUserQuery+remainingInsertQuery);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

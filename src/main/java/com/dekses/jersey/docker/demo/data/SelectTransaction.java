package com.dekses.jersey.docker.demo.data;

import com.dekses.jersey.docker.demo.model.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTransaction {

    private String getUserQuery="select userid from sys.user where userid=";

    public boolean isFirstTimeUser(Event event) {
        try{
            String remainingSelectQuery = Integer.toString(event.getUserId());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys","root","root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(getUserQuery+remainingSelectQuery);
            if(rs.next() == false)
                return true;
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
}

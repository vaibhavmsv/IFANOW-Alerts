package com.dekses.jersey.docker.demo.impl;

import com.dekses.jersey.docker.demo.AdminRules;
import com.dekses.jersey.docker.demo.data.EventTransaction;
import com.dekses.jersey.docker.demo.model.Event;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminRulesImpl implements AdminRules {

    private EventTransaction eventTransaction = new EventTransaction();

    @Override
    public boolean isFirstBillPayForUser(Event event) {
        return eventTransaction.isExistingUser(event);
    }

    @Override
    public boolean shouldAlertUserAboutRuleTwo(Event event) {
        ResultSet resultSet = eventTransaction.getEventsForUser(event);
        JSONParser jsonParser = new JSONParser();
        int totalCount = 0, totalPaymentWorth = 0;
        String dateOfLastTransaction = "";
        try{
            while(resultSet.next()) {
                totalCount += 1;
                String noun = resultSet.getString("noun");
                String verb = resultSet.getString("verb");
                if(noun.equalsIgnoreCase("bill") && noun.equalsIgnoreCase("pay")) {
                    String properties = resultSet.getString("properties");
                    try {
                        JSONObject propertiesJson = (JSONObject)jsonParser.parse(properties);
                        totalPaymentWorth += (Integer) propertiesJson.get("value");
                        dateOfLastTransaction = (String) propertiesJson.get("ts");
                    }
                    catch (ParseException e){
                        System.out.println(e);
                    }
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try{
            Date date = simpleDateFormat.parse(dateOfLastTransaction);
            long millis = date.getTime();
            Date currentDate = new Date();
            long currentMillis = currentDate.getTime();
            if(currentMillis - millis > 300000)
                return false;
        }
        catch (java.text.ParseException e){
            System.out.println(e);
        }
        if(totalCount >= 5 && totalPaymentWorth >= 20000)
            return true;
        return false;
    }

    @Override
    public boolean shouldAlertIFANOWTeam(Event event) {
        return false;
    }

}

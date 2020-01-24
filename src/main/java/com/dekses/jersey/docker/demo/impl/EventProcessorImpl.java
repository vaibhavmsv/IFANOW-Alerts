package com.dekses.jersey.docker.demo.impl;

import com.dekses.jersey.docker.demo.AdminRules;
import com.dekses.jersey.docker.demo.EventProcessor;
import com.dekses.jersey.docker.demo.data.EventTransaction;
import com.dekses.jersey.docker.demo.model.Event;

public class EventProcessorImpl implements EventProcessor {

    private AdminRules adminRules;
    private EventTransaction eventTransaction;

    @Override
    public String processEvent(Event event) {
        adminRules = new AdminRulesImpl();
        eventTransaction = new EventTransaction();
        if(adminRules.isFirstBillPayForUser(event)) {
            eventTransaction.insertUser(event);
            eventTransaction.insertEventData(event);
            return "This is the first payment of user "+event.getUserId();
        }
        else if(adminRules.shouldAlertUserAboutRuleTwo(event)) {
            eventTransaction.insertEventData(event);
            return "5 or more bill pay events of total value >= 20000 happened within 5 minutes window";
        } else {
            eventTransaction.insertEventData(event);
        }
        return null;
    }
}

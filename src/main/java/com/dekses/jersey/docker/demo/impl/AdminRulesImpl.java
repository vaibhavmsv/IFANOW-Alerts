package com.dekses.jersey.docker.demo.impl;

import com.dekses.jersey.docker.demo.AdminRules;
import com.dekses.jersey.docker.demo.data.EventTransaction;
import com.dekses.jersey.docker.demo.model.Event;

public class AdminRulesImpl implements AdminRules {

    private EventTransaction eventTransaction = new EventTransaction();

    @Override
    public boolean isFirstBillPayForUser(Event event) {
        return eventTransaction.isExistingUser(event);
    }

    @Override
    public boolean shouldAlertUserAboutRuleTwo(Event event) {
        return false;
    }

    @Override
    public boolean shouldAlertIFANOWTeam(Event event) {
        return false;
    }

}

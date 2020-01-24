package com.dekses.jersey.docker.demo;

import com.dekses.jersey.docker.demo.model.Event;

public interface AdminRules {

    public boolean isFirstBillPayForUser(Event event);

    public boolean shouldAlertUserAboutRuleTwo(Event event);

    public boolean shouldAlertIFANOWTeam(Event event);
}

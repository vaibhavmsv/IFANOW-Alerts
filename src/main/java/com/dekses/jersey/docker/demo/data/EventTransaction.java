package com.dekses.jersey.docker.demo.data;

import com.dekses.jersey.docker.demo.model.Event;

public class EventTransaction {

    private InsertTransaction insertTransaction  = new InsertTransaction();
    private SelectTransaction selectTransaction;

    public void insertEventData(Event event) {
        insertTransaction.insertEvent(event);
    }

    public boolean isExistingUser(Event event) {
        selectTransaction = new SelectTransaction();
        return selectTransaction.isFirstTimeUser(event);
    }

    public void insertUser(Event event) {
        insertTransaction.insertUserData(event);
    }
}

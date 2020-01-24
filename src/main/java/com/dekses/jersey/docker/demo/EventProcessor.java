package com.dekses.jersey.docker.demo;

import com.dekses.jersey.docker.demo.model.Event;

public interface EventProcessor {

    public String processEvent(Event event);

}

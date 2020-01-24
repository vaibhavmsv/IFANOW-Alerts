package com.dekses.jersey.docker.demo;

import com.dekses.jersey.docker.demo.impl.EventProcessorImpl;
import com.dekses.jersey.docker.demo.model.Event;
import org.json.simple.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Produces("text/plain")
    public String getIt(@QueryParam("userId") int userId,
                        @QueryParam("eventTime") String eventTime,
                        @QueryParam("timeSpent") int timeSpent,
                        @QueryParam("properties") JSONObject properties,
                        @QueryParam("eventLocLongitude") long eventLocLongitude,
                        @QueryParam("noun") String noun,
                        @QueryParam("pay") String pay) {
        Event event = new Event(userId, eventTime, eventLocLongitude, noun, pay, timeSpent, properties);
        EventProcessor eventProcessor = new EventProcessorImpl();
        String finalResponse = eventProcessor.processEvent(event);
        System.out.println(finalResponse);
        return finalResponse;
    }
}

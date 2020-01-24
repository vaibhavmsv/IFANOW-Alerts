package com.dekses.jersey.docker.demo.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.ext.ParamConverter;

public class JSONObjectParamConverter implements ParamConverter<JSONObject> {

    @Override
    public JSONObject fromString(String s) {
        JSONParser jsonParser = new JSONParser();
        try {
            return (JSONObject)jsonParser.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString(JSONObject jsonObject) {
        return jsonObject.toString();
    }

}

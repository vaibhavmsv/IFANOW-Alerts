package com.dekses.jersey.docker.demo.model;

import org.json.simple.JSONObject;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class JSONObjectParamConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {
        if(aClass.equals(JSONObject.class)){
            return (ParamConverter<T>) new JSONObjectParamConverter();
        }
        return null;
    }
}

package com.learn.springboot.utils.JSON;

public class JSONException extends Exception {

    public JSONException(String message){
        super(message);
    }

    public JSONException(Throwable t) {
        super(t);
    }

    public JSONException(String message, Throwable t) {
        super(message, t);
    }
}

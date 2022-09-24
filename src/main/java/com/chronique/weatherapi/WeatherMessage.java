package com.chronique.weatherapi;

public class WeatherMessage {

    private static final String type = "WEATHER";

    private WeatherData data;

    private String message;

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType(){
        return type;
    }
    
}

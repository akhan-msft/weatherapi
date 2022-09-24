package com.chronique.weatherapi;

public class WeatherAndAirQuality {

    private WeatherMessage weather;

    private AirQualityMessage airQuality;

    public WeatherMessage getWeather() {
        return weather;
    }

    public void setWeather(WeatherMessage weather) {
        this.weather = weather;
    }

    public AirQualityMessage getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AirQualityMessage airQuality) {
        this.airQuality = airQuality;
    }

    
    
}

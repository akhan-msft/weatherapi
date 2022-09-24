package com.chronique.weatherapi;

import java.util.List;

public class AirQualityMessage {

    private static final String type = "AIR_QUALITY";

    private String message;

    private AirQualityData[] stations;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AirQualityData[] getStations() {
        return stations;
    }

    public void setStations(AirQualityData[] stations) {
        this.stations = stations;
    }


}

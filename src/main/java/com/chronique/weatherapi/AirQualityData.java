package com.chronique.weatherapi;

public class AirQualityData {


    private String placeName;

    private String postalCode;

    private String state;

    private AqiInfo aqiInfo;

   
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public AqiInfo getAqiInfo() {
        return aqiInfo;
    }

    public void setAqiInfo(AqiInfo aqiInfo) {
        this.aqiInfo = aqiInfo;
    }

    

    
    
}

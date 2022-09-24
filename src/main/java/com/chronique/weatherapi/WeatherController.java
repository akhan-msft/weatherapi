package com.chronique.weatherapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("chronique")
public class WeatherController {

    private static final String API_KEY_NAME = "x-api-key";

    private static final String API_KEY_VALUE = "b2904898b44825eff95503a7a878e96f9be430b861c055ff1a814725d4774ead";


    @GetMapping(path = "/currentWeather", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<WeatherMessage> getData(@RequestParam double lat, @RequestParam double lon ) throws Exception {
        
        if(lat==0.0d | lon==0.0d)
            throw new Exception("Missing required parameters");

        return getWeather(lat, lon);
    }

    @GetMapping(path = "/currentAirQuality", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<AirQualityMessage> getAirQuality(@RequestParam double lat, @RequestParam double lon) throws Exception {
        if(lat==0.0d | lon==0.0d)
            throw new Exception("Missing required parameters");

        return getAirQualityData(lat, lon);
    }

    @GetMapping(path = "/combinedWeather", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<WeatherMessage> combined(@RequestParam double lat, @RequestParam double lon) throws Exception {
        if(lat==0.0d | lon==0.0d)
            throw new Exception("Missing required parameters");

        return fetchWeatherAndPollen(lat, lon);
    }
    
    public Mono<WeatherMessage> getWeather(double latitude, double longitude) {

        WebClient client = WebClient.create();
        Mono<WeatherMessage> result = client
        .get()
        .uri("https://api.ambeedata.com/weather/latest/by-lat-lng?lat=" + latitude + "&lng=" + longitude)
        .header(API_KEY_NAME, API_KEY_VALUE)
        .retrieve()
        .bodyToMono(WeatherMessage.class);
        
        return result;
    }


    public Mono<AirQualityMessage> getAirQualityData(double latitude, double longitude) {

        WebClient client = WebClient.create();
        Mono<AirQualityMessage> result = client
        .get()
        .uri("https://api.ambeedata.com/latest/by-lat-lng?lat=" + latitude + "&lng=" + longitude)
        .header(API_KEY_NAME, API_KEY_VALUE)
        .retrieve()
        .bodyToMono(AirQualityMessage.class);
        
        return result;
    }
    
    
    public Mono fetchWeatherAndPollen(double latitude, double longitude) {
        Mono weather = getWeather(latitude, longitude);
        Mono aq = getAirQualityData(latitude, longitude);
        return Mono.zip(weather, aq);
    }

 

}

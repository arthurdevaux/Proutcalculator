package com.example.devauxarthur.proutcalculator;

/**
 * Created by devauxarthur on 23/01/2017.
 */

public class Coordonnées {

    private String latitude;
    private String longitude;
    private String smell;

    public Coordonnées(String latitude, String longitude, String smell) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.smell = smell;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }


}

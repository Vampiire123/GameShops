package com.example.syl.gameshopsmvp.global.model;

public class Shop {
    String name, address, locality, zipCode;
    float latitude, longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "\nName: " + this.name +
                "\nAddress: " + this.address +
                "\nZip: " + this.zipCode +
                "\nLocality: " + this.locality +
                "\nLatitude: " + this.latitude +
                "\nLongitude: " + this.longitude;
    }
}
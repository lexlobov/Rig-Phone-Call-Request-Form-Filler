package com.issart.rig.model;

public class Driver {
    private final String firstName = "Frank";
    private final String lastName = "Jones";
    private String longitude;
    private String latitude;
    private Vehicle vehicle;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Driver withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public Driver withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public Driver withVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}

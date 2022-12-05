package com.issart.rig.model;

public class Driver {
    private String firstName;
    private String lastName;
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

    public Driver withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Driver withLastName(String lastName) {
        this.lastName = lastName;
        return this;
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

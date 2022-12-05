package com.issart.rig.model;

public class Vehicle {
    private String mcNumber;
    private String dotNumber;
    private String vinNumber;
    private String manufacturer;
    private String year;
    private String model;

    public String getMcNumber() {
        return mcNumber;
    }

    public String getDotNumber() {
        return dotNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public Vehicle withMcNumber(String mcNumber) {
        this.mcNumber = mcNumber;
        return this;
    }

    public Vehicle withDotNumber(String dotNumber) {
        this.dotNumber = dotNumber;
        return this;
    }

    public Vehicle withVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
        return this;
    }

    public Vehicle withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public Vehicle withYear(String year) {
        this.year = year;
        return this;
    }

    public Vehicle withModel(String model) {
        this.model = model;
        return this;
    }
}

package com.sehalsein.footaballbookingadmin.Pojo;

/**
 * Created by sehalsein on 24/06/16.
 */
public class GroundInfo {

    private String groundName;
    private int openingHour;
    private int openingMinute;
    private int closingHour;
    private int closingMinute;
    private double price;
    private String groundType;
    private String address;
    private String key;

    public GroundInfo() {
    }

    public GroundInfo(String groundName, int openingHour, int openingMinute, int closingHour, int closingMinute, double price, String groundType, String address) {
        this.groundName = groundName;
        this.openingHour = openingHour;
        this.openingMinute = openingMinute;
        this.closingHour = closingHour;
        this.closingMinute = closingMinute;
        this.price = price;
        this.groundType = groundType;
        this.address = address;
    }

    public GroundInfo(String groundName, int openingHour, int openingMinute, int closingHour, int closingMinute, double price, String groundType, String address, String key) {
        this.groundName = groundName;
        this.openingHour = openingHour;
        this.openingMinute = openingMinute;
        this.closingHour = closingHour;
        this.closingMinute = closingMinute;
        this.price = price;
        this.groundType = groundType;
        this.address = address;
        this.key = key;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getOpeningMinute() {
        return openingMinute;
    }

    public void setOpeningMinute(int openingMinute) {
        this.openingMinute = openingMinute;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }

    public int getClosingMinute() {
        return closingMinute;
    }

    public void setClosingMinute(int closingMinute) {
        this.closingMinute = closingMinute;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGroundType() {
        return groundType;
    }

    public void setGroundType(String groundType) {
        this.groundType = groundType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

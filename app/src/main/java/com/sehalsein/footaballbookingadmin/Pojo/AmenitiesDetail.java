package com.sehalsein.footaballbookingadmin.Pojo;

/**
 * Created by sehalsein on 24/06/16.
 */
public class AmenitiesDetail {

    private boolean washroom;
    private boolean equipmentRental;
    private boolean sittingArea;
    private boolean drinkingWater;
    private boolean parking;
    private boolean changingRoom;
    private boolean agreement;
    private String key;

    public AmenitiesDetail() {
    }

    public AmenitiesDetail(boolean washroom, boolean equipmentRental, boolean sittingArea, boolean drinkingWater, boolean parking, boolean changingRoom) {
        this.washroom = washroom;
        this.equipmentRental = equipmentRental;
        this.sittingArea = sittingArea;
        this.drinkingWater = drinkingWater;
        this.parking = parking;
        this.changingRoom = changingRoom;
    }

    public AmenitiesDetail(boolean washroom, boolean equipmentRental, boolean sittingArea, boolean drinkingWater, boolean parking, boolean changingRoom, String key) {
        this.washroom = washroom;
        this.equipmentRental = equipmentRental;
        this.sittingArea = sittingArea;
        this.drinkingWater = drinkingWater;
        this.parking = parking;
        this.changingRoom = changingRoom;
        this.key = key;
    }

    public boolean isWashroom() {
        return washroom;
    }

    public void setWashroom(boolean washroom) {
        this.washroom = washroom;
    }

    public boolean isEquipmentRental() {
        return equipmentRental;
    }

    public void setEquipmentRental(boolean equipmentRental) {
        this.equipmentRental = equipmentRental;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isSittingArea() {
        return sittingArea;
    }

    public void setSittingArea(boolean sittingArea) {
        this.sittingArea = sittingArea;
    }

    public boolean isDrinkingWater() {
        return drinkingWater;
    }

    public void setDrinkingWater(boolean drinkingWater) {
        this.drinkingWater = drinkingWater;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isChangingRoom() {
        return changingRoom;
    }

    public void setChangingRoom(boolean changingRoom) {
        this.changingRoom = changingRoom;
    }

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }
}

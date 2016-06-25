package com.sehalsein.footaballbookingadmin.Pojo;

/**
 * Created by sehalsein on 24/06/16.
 */
public class ManagerDetail {

    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;
    private String groundName;
    private String key;

    public ManagerDetail() {
    }

    public ManagerDetail(String firstName, String lastName, String emailId, String phoneNumber, String groundName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.groundName = groundName;
    }

    public ManagerDetail(String firstName, String lastName, String emailId, String phoneNumber, String groundName, String key) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.groundName = groundName;
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }
}

package com.sehalsein.footaballbookingadmin.Pojo;

/**
 * Created by sehalsein on 23/06/16.
 */
public class ProfileSetting {
    private int icon;
    private String text;

    public ProfileSetting() {
    }

    public ProfileSetting(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

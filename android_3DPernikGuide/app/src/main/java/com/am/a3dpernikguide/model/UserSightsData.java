package com.am.a3dpernikguide.model;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class UserSightsData {
    private String fortressCount;
    private String fortressTime;
    private String museumCount;
    private String museumVisit;

    private static UserSightsData instance;

    public static synchronized UserSightsData getInstance() {
        if (instance == null) {
            instance = new UserSightsData();
        }
        return instance;
    }

    public String getFortressCount() {
        return fortressCount;
    }

    public void setFortressCount(String fortressCount) {
        this.fortressCount = fortressCount;
    }

    public String getFortressTime() {
        return fortressTime;
    }

    public void setFortressTime(String fortressTime) {
        this.fortressTime = fortressTime;
    }

    public String getMuseumCount() {
        return museumCount;
    }

    public void setMuseumCount(String museumCount) {
        this.museumCount = museumCount;
    }

    public String getMuseumVisit() {
        return museumVisit;
    }

    public void setMuseumVisit(String museumVisit) {
        this.museumVisit = museumVisit;
    }
}

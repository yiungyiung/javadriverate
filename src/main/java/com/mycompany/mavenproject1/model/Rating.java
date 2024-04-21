/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.model;

/**
 *
 * @author yash
 */
import java.sql.Timestamp;

public class Rating {
    private int ratingId;
    private boolean goodRating;
    private boolean badRating;
    private byte[] picture; // Assuming you want to handle the picture as a byte array
    private String comment;
    private int driverId;
    private String vehicleNumber;
    private Timestamp ratingTimestamp;
    private double latitude;
    private double longitude;

    public Rating(int ratingId, boolean goodRating, boolean badRating, byte[] picture, String comment, int driverId, String vehicleNumber, Timestamp ratingTimestamp, double latitude, double longitude) {
        this.ratingId = ratingId;
        this.goodRating = goodRating;
        this.badRating = badRating;
        this.picture = picture;
        this.comment = comment;
        this.driverId = driverId;
        this.vehicleNumber = vehicleNumber;
        this.ratingTimestamp = ratingTimestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

       public Rating(int ratingId, boolean goodRating, boolean badRating, String comment, int driverId, String vehicleNumber, Timestamp ratingTimestamp, double latitude, double longitude) {
        this.ratingId = ratingId;
        this.goodRating = goodRating;
        this.badRating = badRating;
        this.comment = comment;
        this.driverId = driverId;
        this.vehicleNumber = vehicleNumber;
        this.ratingTimestamp = ratingTimestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public boolean isGoodRating() {
        return goodRating;
    }

    public void setGoodRating(boolean goodRating) {
        this.goodRating = goodRating;
    }

    public boolean isBadRating() {
        return badRating;
    }

    public void setBadRating(boolean badRating) {
        this.badRating = badRating;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Timestamp getRatingTimestamp() {
        return ratingTimestamp;
    }

    public void setRatingTimestamp(Timestamp ratingTimestamp) {
        this.ratingTimestamp = ratingTimestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

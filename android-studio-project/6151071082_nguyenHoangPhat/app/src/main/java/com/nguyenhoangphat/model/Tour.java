package com.nguyenhoangphat.model;

import java.io.Serializable;

public class Tour implements Serializable {
    int tourId;
    String tourName;
    String tourDescription;
    int tourAmount;
    String tourSchedule;
    double tourPrice;
    int tourImage;

    public Tour(int tourId, String tourName, String tourDescription, int tourAmount, String tourSchedule, double tourPrice, int tourImage) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.tourAmount = tourAmount;
        this.tourSchedule = tourSchedule;
        this.tourPrice = tourPrice;
        this.tourImage = tourImage;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public int getTourAmount() {
        return tourAmount;
    }

    public void setTourAmount(int tourAmount) {
        this.tourAmount = tourAmount;
    }

    public String getTourSchedule() {
        return tourSchedule;
    }

    public void setTourSchedule(String tourSchedule) {
        this.tourSchedule = tourSchedule;
    }

    public double getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(double tourPrice) {
        this.tourPrice = tourPrice;
    }

    public int getTourImage() {
        return tourImage;
    }

    public void setTourImage(int tourImage) {
        this.tourImage = tourImage;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", tourName='" + tourName + '\'' +
                ", tourDescription='" + tourDescription + '\'' +
                ", tourAmount=" + tourAmount +
                ", tourSchedule='" + tourSchedule + '\'' +
                ", tourPrice=" + tourPrice +
                ", tourImage=" + tourImage +
                '}';
    }
}

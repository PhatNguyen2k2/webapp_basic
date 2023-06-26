package com.example.models;

import android.support.annotation.NonNull;

public class Product {
    String productName;
    double productPrice;
    //Constructor
    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    //Getter & Setter
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return productName + " - " + productPrice;
    }
}

package com.example.cau2de2.models;

import java.io.Serializable;

public class Product implements Serializable {
    String ProductId;
    String ProductName;
    double ProductPrice;
    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public Product(String productId, String productName, double productPrice) {
        ProductId = productId;
        ProductName = productName;
        ProductPrice = productPrice;
    }
    @Override
    public String toString() {
        return ProductName;
    }

}

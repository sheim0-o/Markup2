package com.example.markup2;

public final class Product{
    private String productName;
    private String productDescription;
    private int productImage;
    private int cost;

    public Product(String productName, String productDescription, int productResource, int cost){
        this.productName=productName;
        this.productDescription = productDescription;
        this.productImage=productResource;
        this.cost = cost;
    }

    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return this.productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductImage() {
        return this.productImage;
    }
    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getCost() {
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
}
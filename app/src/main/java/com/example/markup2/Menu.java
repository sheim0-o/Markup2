package com.example.markup2;

import java.util.ArrayList;

public class Menu {
    private String name;
    private int image;
    private ArrayList<Product> products;

    public Menu(String name, int image, ArrayList<Product> products){
        this.name=name;
        this.image=image;
        this.products=products;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return this.image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
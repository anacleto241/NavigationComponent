package br.edu.ifsuldeminas.mch.navigationcomponent.model; // Updated package

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int imageResId;

    public Product(int id, String name, String description, double price, int imageResId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }
}
package com.examples.dmozo.cardview;

public class Producto {

    private String title;
    private String subtitle;
    private int image, quantity = 0;

    public Producto(String title, String subtitle, int image) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

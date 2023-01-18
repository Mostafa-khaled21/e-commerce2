package com.example.project.UI.data.LocalData;

import java.util.ArrayList;

public class contact extends ArrayList<contact> {
    String image;
    String name;
    String price;


    public contact(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPrice() {return price;}

    public void setPrice(String price) {this.price = price;
    }
}

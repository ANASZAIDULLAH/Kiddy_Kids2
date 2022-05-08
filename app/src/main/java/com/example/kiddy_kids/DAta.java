package com.example.kiddy_kids;

public class DAta {

    private String price;
    private String items;
    private String age;

    public DAta(String price, String items, String age) {
        this.price = price;
        this.items = items;
        this.age = age;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

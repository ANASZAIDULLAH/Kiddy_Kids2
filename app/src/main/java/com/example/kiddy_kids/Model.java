package com.example.kiddy_kids;

public class Model {
    String productname;
    String productdetail;
    int productpic;



    public Model(String productname, String productdetail, int productpic) {
        this.productname = productname;
        this.productdetail = productdetail;
        this.productpic = productpic;
    }


    public String getProductname() {
        return productname;
    }

    public String getProductdetail() {
        return productdetail;
    }

    public int getProductpic() {
        return productpic;
    }


}

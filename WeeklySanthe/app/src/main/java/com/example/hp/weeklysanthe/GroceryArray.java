package com.example.hp.weeklysanthe;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by HP on 19-03-2023.
 */
public class GroceryArray {
    private  String name;
    private  String price;
    private  String city;
    private  String date;
    private  String apmc;

    public GroceryArray(String name, String price,String city,String date, String apmc)
    {
        this.name=name;
        this.price=price;
        this.city=city;
        this.date=date;
        this.apmc=apmc;

    }
    public String getName(){
        return  name;

    }
    public String getPrice(){
        return  price;

    }
    public String getCity(){
        return  city;

    }
    public String getDate(){
        return  date;

    }
    public String getApmc(){
        return  apmc;

    }
}
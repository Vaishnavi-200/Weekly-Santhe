package com.example.hp.weeklysanthe;

/**
 * Created by HP on 24-03-2023.
 */
class VegArray_page{
    private  String vname;
    private  String price;
    private  String date;
    private  String city;
    private  String location;
    private  String veg;

    public  VegArray_page(String vname,String price,String date,String city,String location,String veg){
        this.vname=vname;
        this.price=price;
        this.date=date;
        this.city=city;
        this.location=location;
        this.veg=veg;

    }
    public String getVname(){
        return  vname;
    }
    public String getPrice(){
        return  price;
    }
    public String getDate(){
        return  date;
    }
    public String getCity(){
        return  city;
    }
    public String getLocation(){
        return  location;
    }
    public String getVeg(){
        return  veg;
    }


}

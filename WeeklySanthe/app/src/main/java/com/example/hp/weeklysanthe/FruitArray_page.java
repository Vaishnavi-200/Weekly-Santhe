package com.example.hp.weeklysanthe;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by HP on 24-03-2023.
 */
class FruitArray_page{
    private  String fname;
    private  String fprice;
    private  String fdate;
    private  String fcity;
    private  String flocation;
    private  String fruit;

    public  FruitArray_page(String fname,String fprice,String fdate,String fcity,String flocation,String fruit){
        this.fname=fname;
        this.fprice=fprice;
        this.fdate=fdate;
        this.fcity=fcity;
        this.flocation=flocation;
        this.fruit=fruit;

    }
    public String getFname(){
        return  fname;
    }
    public String getFprice(){
        return  fprice;
    }
    public String getFdate(){
        return  fdate;
    }
    public String getFcity(){
        return  fcity;
    }
    public String getFlocation(){
        return  flocation;
    }
    public String getFruit(){
        return  fruit;
    }


}

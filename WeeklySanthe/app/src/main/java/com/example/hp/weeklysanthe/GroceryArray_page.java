package com.example.hp.weeklysanthe;

/**
 * Created by HP on 24-03-2023.
 */
class GroceryArray_page{
    private  String gname;
    private  String gprice;
    private  String gdate;
    private  String gcity;
    private  String glocation;
    private  String grocery;

    public  GroceryArray_page(String gname,String gprice,String gdate,String gcity,String glocation,String grocery){
        this.gname=gname;
        this.gprice=gprice;
        this.gdate=gdate;
        this.gcity=gcity;
        this.glocation=glocation;
        this.grocery=grocery;

    }
    public String getGname(){
        return  gname;
    }
    public String getGprice(){
        return  gprice;
    }
    public String getGdate(){
        return  gdate;
    }
    public String getGcity(){
        return  gcity;
    }
    public String getGlocation(){
        return  glocation;
    }
    public String getGrocery(){
        return  grocery;
    }


}

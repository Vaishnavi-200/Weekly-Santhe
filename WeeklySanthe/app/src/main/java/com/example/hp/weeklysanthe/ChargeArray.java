package com.example.hp.weeklysanthe;

/**
 * Created by HP on 25-03-2023.
 */
public class ChargeArray {
    private  String stationid;
    private  String stationname;
    private  String city;
    private  String address;
    private  String mno;
    private  String portdetails;
    private  String chargingcharge;
    private  String latitude;
    private  String longitude;




    public ChargeArray(String stationid, String stationname,String city,String address, String mno, String portdetails,String chargingcharge,String latitude,String longitude)
    {
        this.stationid=stationid;
        this.stationname=stationname;
        this.city=city;
        this.address=address;
        this.mno=mno;
        this.portdetails=portdetails;
        this.chargingcharge=chargingcharge;
        this.latitude=latitude;
        this.longitude=longitude;

    }
    public String getstationid(){
        return  stationid;

    }
    public String getstationname(){
        return  stationname;

    }
    public String getcity(){
        return  city;

    }
    public String getaddress(){
        return  address;

    }
    public String getmno(){
        return  mno;

    }
    public String getportdetails(){
        return  portdetails;

    }
    public String getchargingcharge(){
        return  chargingcharge;

    }
    public String getlatitude(){
        return  latitude;

    }
    public String getlongitude(){
        return  longitude;

    }


}


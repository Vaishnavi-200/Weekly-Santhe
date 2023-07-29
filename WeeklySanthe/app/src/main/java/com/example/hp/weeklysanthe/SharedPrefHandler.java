package com.example.hp.weeklysanthe;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HP on 13-09-2022.
 */

public class SharedPrefHandler {

    SharedPrefHandler sph;
    public static final String CONFIGS = "AppConfig" ;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String val;

    SharedPrefHandler(Context ctx){
        sharedPreferences = ctx.getSharedPreferences(CONFIGS, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getSharedPreferences(String key){
        if(sharedPreferences.contains(key)){
            val = sharedPreferences.getString(key, null);
            return val;
        }else{
            return "NF";
        }

    }

    public void setSharedPreferences(String key,String value) {
        editor.putString(key,value).apply();
    }
}

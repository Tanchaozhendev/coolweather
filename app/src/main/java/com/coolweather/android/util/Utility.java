package com.coolweather.android.util;

import android.text.TextUtils;
import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/12/21 0021.
 */

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){

        if(!TextUtils.isEmpty(response)){

            try {
                JSONArray allprovince=new JSONArray(response);
                for(int i=0;i<allprovince.length();i++){
                    JSONObject provinceobject=allprovince.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceobject.getString("name"));
                    province.setProvinceCode(provinceobject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */

    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject citiesobject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(citiesobject.getString("name"));
                    city.setCityCode(citiesobject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();}
                return  true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */

    public static  boolean handleCountResponse(String response,int  cityId){

        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCount=new JSONArray(response);
                for(int i=0;i<allCount.length();i++){
                    County county=new County();
                    JSONObject countyobject=allCount.getJSONObject(i);
                    county.setCityId(cityId);
                    county.setCountyName(countyobject.getString("name"));
                    county.setWeatherId(countyobject.getString("weather_id"));
                    county.save();}
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}

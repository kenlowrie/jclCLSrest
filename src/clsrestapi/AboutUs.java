/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import com.google.gson.Gson;
import java.io.Serializable;

/**
 *
 * @author ken
 */
public class AboutUs extends Base<AboutUs> implements Serializable{
    
    public ApiObjAboutUs apiObj;

    public AboutUs(String wsUrl){
        super(wsUrl,Constants.API_ABOUT_US);
    }
    public AboutUs(){
        super(Constants.WSURL,Constants.API_ABOUT_US);
    }

    @Override
    public AboutUs load(){
        String json = loadJSONfromWebService();

        Gson gson = new Gson();

        return gson.fromJson(json, this.getClass());
        
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof AboutUs)){
            return false;
        }
        
        AboutUs au = (AboutUs)o;
        
        return dbgObj.equals(au.dbgObj) && apiVer.equals(au.apiVer) && apiObj.equals(au.apiObj) ;
    }
    
    @Override
    public String toString(){
        String s;
        
        s = getHeader() + super.toString() + apiObj.toString();
        
        return s;
    }

}
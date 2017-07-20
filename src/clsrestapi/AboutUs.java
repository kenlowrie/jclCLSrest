/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import jclclsrest.Constants;
import com.google.gson.Gson;

/**
 *
 * @author ken
 */
public class AboutUs extends Base<AboutUs>{
    
    public ApiObjAboutUs apiObj;

    public AboutUs(String wsUrl){
        super(wsUrl,Constants.API_ABOUT_US);
    }
    public AboutUs(){
        super(Constants.WSURL,Constants.API_ABOUT_US);
    }

    @Override
    public AboutUs load(){
        String json = loadJSONfromWebService(webServiceUrl);

        Gson gson = new Gson();

        return gson.fromJson(json, this.getClass());
        
    }
//    public AboutUs parseJSON(){
//        String json = loadJSONfromWebService(webServiceUrl);
//        Gson gson = new Gson();
//        AboutUs tmpVar;// = new AboutUs();
//
//        AboutUs aboutus = gson.fromJson(json, this.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
//        
//        //this.dbgObj = tmpVar.dbgObj;
////        this.apiVer = tmpVar.apiVer;
////        this.apiObj = tmpVar.apiObj;
////        
////        System.out.printf(this.toString());
////        return false;   //TODO: I need to rethink this. Does it make sense?
////        
//        return aboutus;
//    }
//    @Override
//    public boolean parseJSON(String sUrl)
//    {
//        String json = loadJSONfromWebService(sUrl);
//        Gson gson = new Gson();
//        AboutUs tmpVar;// = new AboutUs();
//
//        tmpVar = gson.fromJson(json, this.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
//        
//        this.dbgObj = tmpVar.dbgObj;
//        this.apiVer = tmpVar.apiVer;
//        this.apiObj = tmpVar.apiObj;
//        
//        System.out.printf(this.toString());
//        return false;   //TODO: I need to rethink this. Does it make sense?
//    }
//
    @Override
    public String toString(){
        String s;
        
        s = getHeader() + super.toString() + apiObj.toString();
        
        return s;
    }
}
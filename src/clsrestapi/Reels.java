/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import com.google.gson.Gson;
import jclclsrest.Constants;

/**
 *
 * @author ken
 */
public class Reels extends Base<Reels>{
    public ApiObjReels apiObj;
    

    public Reels(String wsUrl){
        super(wsUrl, Constants.API_REELS);
    }
    public Reels(){
        super(Constants.WSURL,Constants.API_REELS);
    }

    @Override
    public Reels load(){
        String json = loadJSONfromWebService(webServiceUrl);

        Gson gson = new Gson();

        return gson.fromJson(json, this.getClass());
        
    }
//    @Override
//    public boolean parseJSON(String sUrl)
//    {
//        String json = loadJSONfromWebService(sUrl);
//        Gson gson = new Gson();
//        Reels tmpVar;// = new AboutUs();
//
//        tmpVar = gson.fromJson(json, this.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
//        
//        this.dbgObj = tmpVar.dbgObj;
//        this.apiVer = tmpVar.apiVer;
//        this.apiObj = tmpVar.apiObj;
//        
//        System.out.printf(this.toString());
//        return false;
//    }

    @Override
    public String toString(){
        String s;
        
        s = getHeader() + super.toString() + apiObj.toString();
        
        return s;
    }
}
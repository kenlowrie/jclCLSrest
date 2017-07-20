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
    
    public Reels(String wsUrl, String apiName){
        super(wsUrl, apiName);
    }

    public Reels(String wsUrl){
        super(wsUrl, Constants.API_REELS);
    }
    public Reels(){
        super(Constants.WSURL,Constants.API_REELS);
    }

    @Override
    public Reels load(){
        String json = loadJSONfromWebService();

        Gson gson = new Gson();

        return gson.fromJson(json, this.getClass());
        
    }

    @Override
    public String toString(){
        String s;
        
        s = getHeader() + super.toString() + apiObj.toString();
        
        return s;
    }
}
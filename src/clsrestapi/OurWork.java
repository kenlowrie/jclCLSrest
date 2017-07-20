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
public class OurWork extends Base<OurWork>{
    public ApiObjOurWork apiObj;
    

    public OurWork(String wsUrl){
        super(wsUrl, Constants.API_OUR_WORK);
    }
    public OurWork(){
        super(Constants.WSURL,Constants.API_OUR_WORK);
    }

    @Override
    public OurWork load(){
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
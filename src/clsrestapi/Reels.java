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
public class Reels extends Base<Reels> implements Serializable{
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
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Reels)){
            return false;
        }
        
        Reels ri = (Reels)o;
        
        return dbgObj.equals(ri.dbgObj) && apiVer.equals(ri.apiVer) && apiObj.equals(ri.apiObj) ;
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
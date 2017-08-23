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
public class Versions extends Base<Versions> implements Serializable{
    public ApiObjVersions apiObj;
    
    public Versions(String wsUrl, String apiName){
        super(wsUrl, apiName);
    }

    public Versions(String wsUrl){
        super(wsUrl, Constants.API_VERSIONS);
    }
    public Versions(){
        super(Constants.WSURL,Constants.API_VERSIONS);
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Versions)){
            return false;
        }
        
        Versions vi = (Versions)o;
        
        return dbgObj.equals(vi.dbgObj) && apiVer.equals(vi.apiVer) && apiObj.equals(vi.apiObj) ;
    }
    
    @Override
    public Versions load(){
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

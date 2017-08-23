/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import java.io.Serializable;

/**
 *
 * @author Ken Lowrie
 */
public class ApiVer implements Serializable{
    public String apiName;
    public String apiVersion;
    public String apiDataVersion;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiVer)){
            return false;
        }
        
        ApiVer ai = (ApiVer)o;
        
        return  apiName.equals(ai.apiName) && 
                apiVersion.equals(ai.apiVersion) && 
                apiDataVersion.equals(ai.apiDataVersion);
    }

    @Override
    public String toString(){
        String s;
        
        s = "\tapiName: " + apiName + Constants.NL +
            "\tapiVersion: " + apiVersion + Constants.NL +
            "\tapiDataVersion: " + apiDataVersion + Constants.NL;
        
        return s;
    }
    
}

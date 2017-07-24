/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

/**
 *
 * @author Ken Lowrie
 */
public class ApiVer {
    public String apiName;
    public String apiVersion;
    public String apiDataVersion;
    
    @Override
    public String toString(){
        String s;
        
        s = "\tapiName: " + apiName + Constants.NL +
            "\tapiVersion: " + apiVersion + Constants.NL +
            "\tapiDataVersion: " + apiDataVersion + Constants.NL;
        
        return s;
    }
    
}

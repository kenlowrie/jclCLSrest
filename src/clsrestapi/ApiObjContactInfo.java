/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import jclclsrest.Constants;

/**
 *
 * @author ken
 */
public class ApiObjContactInfo {
    public String  location;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Constants.NL +
            "\tLocation: " + location + Constants.NL;
        
        return s;
    }
}

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
public class ApiObjReels {
    public int  numReels;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Constants.NL +
            "\tnumReels: " + numReels + Constants.NL;
        
        return s;
    }
    
}

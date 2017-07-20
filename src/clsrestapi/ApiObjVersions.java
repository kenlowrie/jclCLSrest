/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import java.util.List;
import jclclsrest.Constants;

/**
 *
 * @author ken
 */
public class ApiObjVersions {
    public int  numApis;
    public List<ApiVer> apiList;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Constants.NL +
            "\tnumApis: " + numApis + Constants.NL +
            "\tapiList: " + apiList + Constants.NL;
        
        return s;
    }
    
}

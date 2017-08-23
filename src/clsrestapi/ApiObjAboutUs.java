/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import java.io.Serializable;

/**
 *
 * @author ken
 */
public class ApiObjAboutUs implements Serializable{
    public String  aboutus;
    
    @Override
    public boolean equals(Object o){
        System.out.println("ApiObjAboutUs");
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiObjAboutUs)){
            return false;
        }
        
        ApiObjAboutUs auo = (ApiObjAboutUs)o;
        
        return  aboutus.equals(auo.aboutus);
    }

    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Constants.NL +
            "\taboutUs: " + aboutus + Constants.NL;
        
        return s;
    }
}

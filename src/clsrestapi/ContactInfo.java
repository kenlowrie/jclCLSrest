/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import com.google.gson.Gson;

/**
 *
 * @author ken
 */
public class ContactInfo extends Base<ContactInfo>{
    public ApiObjContactInfo apiObj;
    

    public ContactInfo(String wsUrl){
        super(wsUrl, Constants.API_CONTACT_INFO);
    }
    public ContactInfo(){
        super(Constants.WSURL,Constants.API_CONTACT_INFO);
    }

    @Override
    public ContactInfo load(){
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
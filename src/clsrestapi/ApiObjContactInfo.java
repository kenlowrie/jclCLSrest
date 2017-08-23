/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author Ken Lowrie
 */

class Address implements Serializable{
    public String name;
    public String street;
    public String city;
    public String state;
    public String zipcode;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Address)){
            return false;
        }
        
        Address addr = (Address)o;
        
        return  name.equals(addr.name) &&
                street.equals(addr.street) &&
                city.equals(addr.city) &&
                state.equals(addr.state) &&
                zipcode.equals(addr.zipcode);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("\tAddress:").append(Constants.NL);
        
        sb.append("\t\tName: ").append(name).append(Constants.NL);
        sb.append("\t\tStreet: ").append(street).append(Constants.NL);
        sb.append("\t\tCity: ").append(city).append(Constants.NL);
        sb.append("\t\tState: ").append(state).append(Constants.NL);
        sb.append("\t\tZip: ").append(zipcode).append(Constants.NL);
        
        return sb.toString();
    }
}

public class ApiObjContactInfo implements Serializable {
    public String location;
    public Address address;
    public String email;
    public String phone;
    public List<SocialNetwork> socialNetworks;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiObjContactInfo)){
            return false;
        }
        
        ApiObjContactInfo ci = (ApiObjContactInfo)o;
        
        return  location.equals(ci.location) &&
                address.equals(ci.address) &&
                email.equals(ci.email) &&
                phone.equals(ci.phone) &&
                socialNetworks.equals(ci.socialNetworks);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("apiObj:").append(Constants.NL);
        
        sb.append("\tLocation: ").append(location).append(Constants.NL);
        sb.append(address);
        sb.append("\tEmail: ").append(email).append(Constants.NL);
        sb.append("\tPhone: ").append(phone).append(Constants.NL);

        if( socialNetworks.size() > 0 ){
            sb.append("\tSocialNetworks = [").append(Constants.NL);
            int counter = 0;
            for(ListIterator<SocialNetwork> iter = socialNetworks.listIterator(); iter.hasNext();){
                SocialNetwork sn = iter.next();

                sb.append("\t\tsocialNetworks[").append(counter).append("].network: ").append(sn.network).append(Constants.NL);
                sb.append("\t\tsocialNetworks[").append(counter).append("].id: ").append(sn.id).append(Constants.NL);
                sb.append("\t\tsocialNetworks[").append(counter).append("].url: ").append(sn.url).append(Constants.NL);
                sb.append(Constants.NL);
                counter++;
            }
            sb.append("\t]").append(Constants.NL);
        }
        
        return sb.toString();
    }
}

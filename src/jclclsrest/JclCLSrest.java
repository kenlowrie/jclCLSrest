/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclclsrest;

import java.net.*;
import java.io.*;
import java.util.List;
import com.google.gson.*;
import java.util.ListIterator;


class ClsRestDbgObj {
    public boolean parseOK;
    public List<String> traceMsgQ;
    public List<String> restAPIkeys;
    public String request_uri;
    public String query_string;
    
    
    @Override
    public String toString(){
        String s;
        
        s = "\tparseOK: " + parseOK + Consts.NEW_LINE +
            "\trequest_uri: " + request_uri + Consts.NEW_LINE +
            "\tquery_string: " + query_string + Consts.NEW_LINE +
            "\trestAPIkeys: " + restAPIkeys + Consts.NEW_LINE +
            "\ttraceMsgQ: " + traceMsgQ + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiVer {
    public String apiName;
    public String apiVersion;
    public String apiDataVersion;

    
    @Override
    public String toString(){
        String s;
        
        s = "\tapiName: " + apiName + Consts.NEW_LINE +
            "\tapiVersion: " + apiVersion + Consts.NEW_LINE +
            "\tapiDataVersion: " + apiDataVersion + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiVersionsObj {
    public int  numApis;
    public List<ClsRestApiVer> apiList;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Consts.NEW_LINE +
            "\tnumApis: " + numApis + Consts.NEW_LINE +
            "\tapiList: " + apiList + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiReelsObj {
    public int  numReels;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Consts.NEW_LINE +
            "\tnumReels: " + numReels + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiOurWorkObj {
    public int  numVideos;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Consts.NEW_LINE +
            "\tnumVideos: " + numVideos + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiAboutUsObj {
    public String  aboutus;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Consts.NEW_LINE +
            "\taboutUs: " + aboutus + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiContactInfoObj {
    public String  location;
    
    @Override
    public String toString(){
        String s;
        
        s = "apiObj:" + Consts.NEW_LINE +
            "\tLocation: " + location + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiBase {
    public ClsRestDbgObj dbgObj;
    public ClsRestApiVer apiVer;
    
    @Override
    public String toString(){
        String s;
        
        s = "dbgObj:" + Consts.NEW_LINE + dbgObj.toString() + Consts.NEW_LINE + 
            "apiVer:" + Consts.NEW_LINE + apiVer.toString() + Consts.NEW_LINE;
        
        return s;
    }
}

class ClsRestApiVersions extends ClsRestApiBase{
    public ClsRestApiVersionsObj apiObj;
    @Override
    public String toString(){
        String s;
        
        s = super.toString() + apiObj.toString();
        
        return s;
    }
}

class ClsRestApiReels extends ClsRestApiBase{
    public ClsRestApiReelsObj apiObj;
    @Override
    public String toString(){
        String s;
        
        s = super.toString() + apiObj.toString();
        
        return s;
    }
}

class ClsRestApiOurWork extends ClsRestApiBase{
    public ClsRestApiOurWorkObj apiObj;
    @Override
    public String toString(){
        String s;
        
        s = super.toString() + apiObj.toString();
        
        return s;
    }
}

class ClsRestApiAboutUs extends ClsRestApiBase{
    public ClsRestApiAboutUsObj apiObj;
    @Override
    public String toString(){
        String s;
        
        s = super.toString() + apiObj.toString();
        
        return s;
    }
}

class ClsRestApiContactInfo extends ClsRestApiBase{
    public ClsRestApiContactInfoObj apiObj;
    @Override
    public String toString(){
        String s;
        
        s = super.toString() + apiObj.toString();
        
        return s;
    }
}

/**
 *
 * @author ken
 */
public class JclCLSrest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clsrest();
    }
    
    public static String loadJSONfromWebService(String sUrl){
        try{
            URL url = new URL(sUrl);
            
            InputStream is = url.openStream();
            /*
                I think I should have the logic to make sure what I'm reading is
                content-type:application/json.
            */
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String json = "";
            String current;

            while((current = in.readLine()) != null) {
               json += current;
            }
            return json;
        }catch(FileNotFoundException e){
            System.out.println("URL [" + sUrl + "] not available.");
        }catch(IOException e){
            //e.printStackTrace();
        }
        return "";  // Is this right?
    }
    
    public static void ClsRestVersions(){
            String json = loadJSONfromWebService("http://api.cloudylogic.com/versions/");
            Gson gson = new Gson();
            ClsRestApiVersions versions = new ClsRestApiVersions();

            versions = gson.fromJson(json, versions.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
            
            System.out.printf(versions.toString());
    
    }
    
    public static void ClsRestReels(){
            String json = loadJSONfromWebService("http://api.cloudylogic.com/reels/");
            Gson gson = new Gson();
            ClsRestApiReels reels = new ClsRestApiReels();

            reels = gson.fromJson(json, reels.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
            
            System.out.printf(reels.toString());
    
    }
    
    public static void ClsRestOurWork(){
            String json = loadJSONfromWebService("http://api.cloudylogic.com/our-work/");
            Gson gson = new Gson();
            ClsRestApiOurWork ourWork = new ClsRestApiOurWork();

            ourWork = gson.fromJson(json, ourWork.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
            
            System.out.printf(ourWork.toString());
    
    }

    public static void ClsRestAboutUs(){
            String json = loadJSONfromWebService("http://api.cloudylogic.com/about-us/");
            Gson gson = new Gson();
            ClsRestApiAboutUs aboutUs = new ClsRestApiAboutUs();

            aboutUs = gson.fromJson(json, aboutUs.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
            
            System.out.printf(aboutUs.toString());
    
    }

    public static void ClsRestContactInfo(){
            String json = loadJSONfromWebService("http://api.cloudylogic.com/contact-info/");
            Gson gson = new Gson();
            ClsRestApiContactInfo contactInfo = new ClsRestApiContactInfo();

            contactInfo = gson.fromJson(json, contactInfo.getClass());  // TODO: Is this right? We create a new object then throw it away? Huh?
            
            System.out.printf(contactInfo.toString());
    
    }

    public static void clsrest(){
            /*
        try{
            URL url = new URL("http://api.cloudylogic.com/versions/");
            
            InputStream is = url.openStream();
            /*
                I think I should have the logic to make sure what I'm reading is
                content-type:application/json.
            * /
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String json = "";
            String current;

            while((current = in.readLine()) != null) {
               json += current;
            }
            
            Gson gson = new Gson();
            ClsRestApiVersions versions = new ClsRestApiVersions();

            versions = gson.fromJson(json, versions.getClass());
            
            System.out.printf(versions.toString());
            */
            
            ClsRestVersions();
            ClsRestReels();
            ClsRestOurWork();
            ClsRestAboutUs();
            ClsRestContactInfo();
            /*

            int counter = 0;
            for(ListIterator<ClsRestApiVer> iter = versions.apiObj.apiList.listIterator(); iter.hasNext();){
                ClsRestApiVer apiVer = iter.next();
                System.out.printf("versions.apiObj.apiList[%d].apiName: %s\n",counter,apiVer.apiName);
                System.out.printf("versions.apiObj.apiList[%d].apiVersion: %s\n",counter,apiVer.apiVersion);
                System.out.printf("versions.apiObj.apiList[%d].apiDataVersion: %s\n",counter,apiVer.apiDataVersion);
                counter++;
            }

        }catch(FileNotFoundException e){
            System.out.println("URL not available.");
        }catch(IOException e){
            //e.printStackTrace();
        }
            */
    }
    
}

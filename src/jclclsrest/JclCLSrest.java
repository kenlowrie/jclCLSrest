/*
 * Copyright 2017 Ken Lowrie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This package implements the Java command line client for the CLS REST API.
 */
package jclclsrest;

import java.util.HashMap;
import clsrestapi.AboutUs;
import clsrestapi.ContactInfo;
import clsrestapi.Versions;
import clsrestapi.Reels;
import clsrestapi.OurWork;
import clsrestapi.Constants;


/**
 *  This class implements the Java Command Line Client for the CLS REST API.
 * 
 * @author ken
 */
public class JclCLSrest {
    
    /**
     * The host that will be used to issue the REST API calls against. By default,
     * it is http://api.cloudylogic.com, but can be overridden from the comamnd line.
     */
    static private String host;
    
    static void logMsg(String msg){
        System.out.println(msg);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        host = args.length > 0 ? args[0] : ".";
        String api = args.length > 1 ? args[1] : "*";
        
        //System.out.printf("HOST: %s\n API: %s\n", host, api);
        
        /**
         * If the host field is ".", set it to the default.
         */
        if (host.equals(".")){
            host = Constants.WSURL;
        }
                
        HashMap<String, Runnable> tests = new HashMap<>();
        
        tests.put(Constants.API_REELS, JclCLSrest::ClsRestReels);
        tests.put(Constants.API_ABOUT_US, JclCLSrest::ClsRestAboutUs);
        tests.put(Constants.API_VERSIONS, JclCLSrest::ClsRestVersions);
        tests.put(Constants.API_OUR_WORK, JclCLSrest::ClsRestOurWork);
        tests.put(Constants.API_CONTACT_INFO, JclCLSrest::ClsRestContactInfo);
                
        if (api.equals("*")){
            logMsg("Running ALL CLS REST API tests on " + host);
            clsrest();
        } else if ( tests.keySet().contains(api)){
            logMsg("Running " + host + "/" + api + "/ CLS REST API");
            
            tests.get(api).run();
        } else{
            logMsg("I don't know what [" + api +"] is. Ignoring...");
        }
        
    }
    
    /**
     * This method tests the <em>versions</em> CLS REST API.
     */
    public static void ClsRestVersions(){
        Versions versions = new Versions(host).load();
        
        if (versions != null){
            System.out.println(versions);
        
            versions = new Versions(host, Constants.API_VERSIONS + "/reels/").load();
        
            System.out.println(versions);
                } else {
            logMsg("failed creating instance of Versions class");
        }
    }
    
    /**
     * This method tests the <em>reels</em> CLS REST API.
     */
    public static void ClsRestReels(){
        Reels reels = new Reels(host).load();
        
        if( reels != null ){        
            System.out.println(reels);

            reels = new Reels(host, Constants.API_REELS + "/0/").load();
        
            System.out.println(reels);
        } else {
            logMsg("failed creating instance of Reels class");
        }
    }
    
    /**
     * This method tests the <em>our-work</em> CLS REST API.
     */
    public static void ClsRestOurWork(){
        OurWork ourWork = new OurWork(host).load();
        
        if( ourWork != null){
            System.out.println(ourWork);
        
            ourWork = new OurWork(host, Constants.API_OUR_WORK + "/3/").load();
        
            System.out.println(ourWork);
        } else {
            logMsg("failed creating instance of OurWork class");
        }
    }

    /**
     * This method tests the <em>about-us</em> CLS REST API.
     */
    public static void ClsRestAboutUs(){
        AboutUs aboutus = new AboutUs(host).load();
        
        if (aboutus != null){
            logMsg(aboutus.toString());        
        } else {
            logMsg("failed creating instance of AboutUs class");
        }
    }

    /**
     * This method tests the <em>contact-info</em> CLS REST API.
     */
    public static void ClsRestContactInfo(){
        ContactInfo contactInfo = new ContactInfo(host).load();
        
        if (contactInfo != null){
        
            System.out.println(contactInfo);
                
            System.out.println("zipcode is: " + contactInfo.apiObj.address.zipcode);
        } else {
            logMsg("failed creating instance of ContactInfo class");
        }

    }

    /**
     * This method tests <em>ALL</em> of the CLS REST API's.
     */
    public static void clsrest(){
            ClsRestVersions();
            ClsRestReels();
            ClsRestOurWork();
            ClsRestAboutUs();
            ClsRestContactInfo();
    }
    
}

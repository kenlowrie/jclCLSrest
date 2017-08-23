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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : ".";
        String api = args.length > 1 ? args[1] : "*";
        
        //System.out.printf("HOST: %s\n API: %s\n", host, api);
        
        HashMap<String, Runnable> tests = new HashMap<>();
        
        tests.put(Constants.API_REELS, JclCLSrest::ClsRestReels);
        tests.put(Constants.API_ABOUT_US, JclCLSrest::ClsRestAboutUs);
        tests.put(Constants.API_VERSIONS, JclCLSrest::ClsRestVersions);
        tests.put(Constants.API_OUR_WORK, JclCLSrest::ClsRestOurWork);
        tests.put(Constants.API_CONTACT_INFO, JclCLSrest::ClsRestContactInfo);
        
        //tests.get("reels").run();
        
        if (api.equals("*")){
            System.out.println("Running ALL CLS REST API tests");
            clsrest();
        } else if ( tests.keySet().contains(api)){
            System.out.println("Running "+api+" CLS REST API only");
            
            tests.get(api).run();
        } else{
            System.out.println("I don't know what [" + api +"] is. Ignoring...");
        }
        
    }
    
    /**
     * This method tests the <em>versions</em> CLS REST API.
     */
    public static void ClsRestVersions(){
        Versions versions = new Versions().load();
        
        System.out.println(versions);

        versions = new Versions(Constants.WSURL, Constants.API_VERSIONS + "/reels/").load();
        
        System.out.println(versions);
        
        versions.dumpAndLoad(Constants.API_VERSIONS + ".ser");
    }
    
    public static void ClsRestReels(){
        Reels reels = new Reels().load();
        
        System.out.println(reels);

        reels = new Reels(Constants.WSURL, Constants.API_REELS + "/0/").load();
        
        System.out.println(reels);

        reels.dumpAndLoad(Constants.API_REELS + ".ser");
    }
    
    public static void ClsRestOurWork(){
        OurWork ourWork = new OurWork().load();
        
        System.out.println(ourWork);
        
        ourWork = new OurWork(Constants.WSURL, Constants.API_OUR_WORK + "/3/").load();
        
        System.out.println(ourWork);

        ourWork.dumpAndLoad(Constants.API_OUR_WORK + ".ser");        
    }

    public static void ClsRestAboutUs(){
        AboutUs aboutus = new AboutUs().load();
        
        System.out.println(aboutus);
        
        aboutus.dumpAndLoad(Constants.API_ABOUT_US + ".ser");
    }

    public static void ClsRestContactInfo(){
        ContactInfo contactInfo = new ContactInfo().load();
        
        System.out.println(contactInfo);
        
        contactInfo.dumpAndLoad(Constants.API_CONTACT_INFO + ".ser");
    }

    public static void clsrest(){
            ClsRestVersions();
            ClsRestReels();
            ClsRestOurWork();
            ClsRestAboutUs();
            ClsRestContactInfo();
    }
    
}

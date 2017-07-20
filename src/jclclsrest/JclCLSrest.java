/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This package implements the Java command line client for the CLS REST API.
 */
package jclclsrest;

import clsrestapi.*;


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
        clsrest();
    }
    
    /**
     * This method tests the <em>versions</em> CLS REST API.
     */
    public static void ClsRestVersions(){
        Versions versions = new Versions().load();
        
        System.out.println(versions);

        versions = new Versions(Constants.WSURL, Constants.API_VERSIONS + "/reels/").load();
        
        System.out.println(versions);
    }
    
    public static void ClsRestReels(){
        Reels reels = new Reels().load();
        
        System.out.println(reels);

        reels = new Reels(Constants.WSURL, Constants.API_REELS + "/0/").load();
        
        System.out.println(reels);
    }
    
    public static void ClsRestOurWork(){
        OurWork ourWork = new OurWork().load();
        
        System.out.println(ourWork);
        
        ourWork = new OurWork(Constants.WSURL, Constants.API_OUR_WORK + "/3/").load();
        
        System.out.println(ourWork);
    }

    public static void ClsRestAboutUs(){
        AboutUs aboutus = new AboutUs().load();
        
        System.out.println(aboutus);
    }

    public static void ClsRestContactInfo(){
        ContactInfo contactInfo = new ContactInfo().load();
        
        System.out.println(contactInfo);
//            ContactInfo contactInfo = new ContactInfo();
//            
//            if( contactInfo.parseJSON("http://api.cloudylogic.com/contact-info/") )
//                System.out.printf(contactInfo.toString());
    }

    public static void clsrest(){
            ClsRestVersions();
            ClsRestReels();
            ClsRestOurWork();
            ClsRestAboutUs();
            ClsRestContactInfo();
    }
    
}

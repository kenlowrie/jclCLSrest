/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import java.net.*;
import java.io.*;
import java.util.Collections;
import jclclsrest.Constants;

/**
 * This is the base class for the CLS REST API set. Each API contains three
 * objects, a DbgObj object, an ApiVer object and an API-specific object which
 * will be defined by the class that extends the base class.
 * 
 * This is marked as an abstract class because we have one method, parseJSON,
 * which must be implemented by the consumer.
 * 
 * @author Ken Lowrie
 * @param <T> When this class is extended, you must specify the class of the
 * extender that will be returned by the abstract methods within.
 */
public abstract class Base<T> {

    /**
     * This URL is the fully qualified URL for this API instance.
     */
    protected String webServiceUrl;
    
    /**
     * This is the String name of the current API instance. 
     */
    protected String apiName;

    /**
     * This holds the dbgObj JSON object from a CLS REST API call.
     */
    public DbgObj dbgObj;
    
    /**
     * This holds the apiVer JSON object from a CLS REST API call.
     */
    public ApiVer apiVer;
    
    /**
     * This is the constructor for the Base class. You pass in the host path
     * and the apiName, and the fully qualified name is constructed on the fly.
     * This allows you to override the host path, primarily useful for debugging.
     * 
     * @param wsUrlRoot The host name to issue the API call to. Default is
     * http://api.cloudylogic.com.
     * 
     * @param apiName The apiName for this object instance. e.g. reels.
     */
    public Base(String wsUrlRoot,String apiName){
        this.apiName = apiName;
        this.webServiceUrl = makeUrl(wsUrlRoot);
    }
    
    /**
     * Constructs the web service URL for this instance. The apiName has
     * been filled out in the constructor before this method is invoked.
     * 
     * @param wsUrlRoot The web service URL. If no ending '/', it will be added.
     * @return The fully qualified URL for the API.
     */
    private String makeUrl(String wsUrlRoot){        
        StringBuilder s = new StringBuilder(wsUrlRoot);
        
        if (!wsUrlRoot.endsWith("/")) s.append('/');
        
        s.append(apiName);
        
        return s.toString();
    }
    
    /**
     * This method loads the JSON data from a web service. If it does not see
     * a header of Content-Type == application/json, it will throw an 
     * AssertionError.
     * 
     * @param sUrl String specifying the URL of the web service to invoke.
     * @return String containing the JSON data from the web service.
     */
    public String loadJSONfromWebService(){
        try{
            URL url = new URL(webServiceUrl);
            
            URLConnection conn = url.openConnection();
            
            //TODO: Should I be more specific with this assertion?
            if(!"application/json".equals(conn.getHeaderField("Content-Type"))){
                throw new AssertionError();
            }
        
            InputStream is = url.openStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String json = "";
            String current;

            while((current = in.readLine()) != null) {
               json += current;
            }
            return json;
        }catch(FileNotFoundException e){
            System.out.println("URL [" + webServiceUrl + "] not available.");
        }catch(IOException e){
            //e.printStackTrace();
        }
        return "";  // Is this right?
    }
    
    public String getHeader(){
        String dashes = String.join("", Collections.nCopies(40, "-"));

        StringBuilder s = new StringBuilder(dashes);
        
        s.append(Constants.NL);
        s.append("API:");
        s.append(apiName);
        s.append(Constants.NL);
        s.append(dashes);
        s.append(Constants.NL);

        return s.toString();
    }
    /**
     * This is an abstract method for the base class. Consumers of this class
     * are required to override this method with the code to load the object
     * by initiated the network call and parsing the JSON.
     * 
     * @return The type of the class that extends this class.
     */
    public abstract T load();
    
    @Override
    public String toString(){
        String s;
        
        s = "dbgObj:" + Constants.NL + dbgObj.toString() + Constants.NL + 
            "apiVer:" + Constants.NL + apiVer.toString() + Constants.NL;
        
        return s;
    }
    
}

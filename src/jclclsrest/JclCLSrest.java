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

class ClsRestDbgObj{
    public boolean parseOK;
    public List<String> traceMsgQ;
    public List<String> restAPIkeys;
    public String request_uri;
    public String query_string;
    
    private static final String CRLF = "\r\n";
    
    @Override
    public String toString(){
        String s;
        
        s = "\tparseOK: " + parseOK + CRLF +
            "\trequest_uri: " + request_uri + CRLF +
            "\tquery_string: " + query_string + CRLF +
            "\trestAPIkeys: " + restAPIkeys + CRLF +
            "\ttraceMsgQ: " + traceMsgQ + CRLF;
        
        return s;
    }
}

class ClsRestApiVer{
    public String apiName;
    public String apiVersion;
    public String apiDataVersion;

    private static final String CRLF = "\r\n";
    
    @Override
    public String toString(){
        String s;
        
        s = "\tapiName: " + apiName + CRLF +
            "\tapiVersion: " + apiVersion + CRLF +
            "\tapiDataVersion: " + apiDataVersion + CRLF;
        
        return s;
    }
}

class ClsRestApiObjVersions{
    public int  numApis;
    public List<ClsRestApiVer> apiList;

    private static final String CRLF = "\r\n";
    
    @Override
    public String toString(){
        String s;
        
        s = "\tnumApis: " + numApis + CRLF +
            "\tapiList: " + apiList + CRLF;
        
        return s;
    }
}

class ClsRestApi{
    public ClsRestDbgObj dbgObj;
    public ClsRestApiVer apiVer;
    public ClsRestApiObjVersions apiObj;

    private static final String CRLF = "\r\n";
    
    @Override
    public String toString(){
        String s;
        
        s = "dbgObj:\r\n"+dbgObj.toString() + CRLF + 
            "apiVer:\r\n"+apiVer.toString() + CRLF + 
            "apiObj:\r\n"+apiObj.toString();
        
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
    /*
    public static void clsrest(){
        try{
            URL url = new URL("http://api.cloudylogic.com/versions/");
            InputStream is = url.openStream();
                BufferedReader in = new BufferedReader(
                       new InputStreamReader(is));
                    String urlString = "";
                    String current;

                    while((current = in.readLine()) != null) {
                       urlString += current;
                    }
                    //System.out.println(urlString);
                    
                    JSONParser parser = new JSONParser();

                    Object obj = parser.parse(urlString);

                    JSONObject jsonObject = (JSONObject) obj;
                    System.out.println(jsonObject);

                    //String name = (String) jsonObject.get("dbgObj");
                    System.out.println(jsonObject.get("dbgObj"));
                    System.out.println(jsonObject.get("apiVer"));
                    System.out.println(jsonObject.get("apiObj"));

                }catch(IOException e){
                    e.printStackTrace();
                }catch(ParseException e){
                    e.printStackTrace();                
                }
    }
*/
    public static void clsrest(){
        try{
            URL url = new URL("http://api.cloudylogic.com/versions/");
            
            InputStream is = url.openStream();
            /*
                what about Object obj = url.getContent();?
                obj.toString();?
                or
                String json = url.getContent().toString();
                or
                String json = url.toString()?;
            
                //Object json = url.getContent();
                //System.out.println(json.getClass().getName());
            
                This might be used to later deal with the images...
            
                I think I should have the logic to make sure what I'm reading is
                content-type:application/json.
            
            */
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String json = "";
            String current;

            while((current = in.readLine()) != null) {
               json += current;
            }
            
            Gson gson = new Gson();
            ClsRestApi versions = new ClsRestApi();

            versions = gson.fromJson(json, versions.getClass());
            
            System.out.printf(versions.toString());
            /*
            System.out.printf("versions.apiVer.apiName: %s\n", versions.apiVer.apiName);
            System.out.printf("versions.apiVer.apiVersion: %s\n", versions.apiVer.apiVersion);
            System.out.printf("versions.apiVer.apiDataVersion: %s\n", versions.apiVer.apiDataVersion);

            System.out.printf("versions.apiObj.numApis: %d\n", versions.apiObj.numApis);

            int counter = 0;
            for(ListIterator<ClsRestApiVer> iter = versions.apiObj.apiList.listIterator(); iter.hasNext();){
                ClsRestApiVer apiVer = iter.next();
                System.out.printf("versions.apiObj.apiList[%d].apiName: %s\n",counter,apiVer.apiName);
                System.out.printf("versions.apiObj.apiList[%d].apiVersion: %s\n",counter,apiVer.apiVersion);
                System.out.printf("versions.apiObj.apiList[%d].apiDataVersion: %s\n",counter,apiVer.apiDataVersion);
                counter++;
            }
            */

        }catch(FileNotFoundException e){
            System.out.println("URL not available.");
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        //}catch(ParseException e){
          //  e.printStackTrace();                
        }
    }
    
}

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
 * @author ken
 */
public class ApiObjVersions implements Serializable{
    public int  numApis;
    public List<ApiVer> apiList;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiObjVersions)){
            return false;
        }
        
        ApiObjVersions vi = (ApiObjVersions)o;
        
        return  numApis == vi.numApis &&
                apiList.equals(vi.apiList);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("apiObj:").append(Constants.NL);
        
        sb.append("\tnumApis: ").append(numApis).append(Constants.NL);
        sb.append("\tapiList: ").append(Constants.NL);
        
        int counter = 0;
        for(ListIterator<ApiVer> iter = apiList.listIterator(); iter.hasNext();){
            ApiVer version = iter.next();
            
            sb.append("\t\tapiList[").append(counter).append("].apiName: ").append(version.apiName).append(Constants.NL);
            sb.append("\t\tapiList[").append(counter).append("].apiVersion: ").append(version.apiVersion).append(Constants.NL);
            sb.append("\t\tapiList[").append(counter).append("].apiDataVersion: ").append(version.apiDataVersion).append(Constants.NL);
            sb.append(Constants.NL);
            counter++;
        }
        return sb.toString();
    }
    
}

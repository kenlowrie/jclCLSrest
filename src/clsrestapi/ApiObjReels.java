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
 * This class encapsulates the 'reels' CLS REST API data.
 * 
 * @author Ken Lowrie
 */
public class ApiObjReels implements Serializable{
    public int  numReels;
    public List<Video> reelList;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiObjReels)){
            return false;
        }
        
        ApiObjReels ri = (ApiObjReels)o;
        
        return  numReels == ri.numReels &&
                reelList.equals(ri.reelList);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("apiObj:" + Constants.NL);

        sb.append("\tnumReels: ").append(numReels).append(Constants.NL);
        sb.append("\treelList: ").append(Constants.NL);

        int counter = 0;
        for(ListIterator<Video> iter = reelList.listIterator(); iter.hasNext();){
            Video video = iter.next();
            
            sb.append("\t\treelList[").append(counter).append("].title: ").append(video.title).append(Constants.NL);
            sb.append("\t\treelList[").append(counter).append("].url: ").append(video.url).append(Constants.NL);
            sb.append("\t\treelList[").append(counter).append("].sUrl: ").append(video.sUrl).append(Constants.NL);
            sb.append("\t\treelList[").append(counter).append("].thumb: ").append(video.thumb).append(Constants.NL);
            sb.append("\t\treelList[").append(counter).append("].frame: ").append(video.frame).append(Constants.NL);
            sb.append(Constants.NL);
            counter++;
        }
        
        return sb.toString();
    }
    
}

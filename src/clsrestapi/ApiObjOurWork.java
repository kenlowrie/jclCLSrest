/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author ken
 */
public class ApiObjOurWork {
    public int  numVideos;
    public List<ShowCaseVideo> videoList;
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("apiObj:").append(Constants.NL);
        
        sb.append("\tnumVideos: ").append(numVideos).append(Constants.NL);
        sb.append("\tvideoList: ").append(Constants.NL);
        
        int counter = 0;
        for(ListIterator<ShowCaseVideo> iter = videoList.listIterator(); iter.hasNext();){
            ShowCaseVideo video = iter.next();
            
            sb.append("\t\tvideoList[").append(counter).append("].title: ").append(video.title).append(Constants.NL);
            sb.append("\t\tvideoList[").append(counter).append("].url: ").append(video.url).append(Constants.NL);
            sb.append("\t\tvideoList[").append(counter).append("].sUrl: ").append(video.sUrl).append(Constants.NL);
            sb.append("\t\tvideoList[").append(counter).append("].thumb: ").append(video.thumb).append(Constants.NL);
            sb.append("\t\tvideoList[").append(counter).append("].frame: ").append(video.frame).append(Constants.NL);
            sb.append("\t\tvideoList[").append(counter).append("].type: ").append(video.type).append(Constants.NL);
            sb.append("\t\tvideoList[").append(counter).append("].role: ").append(video.roles).append(Constants.NL);
            sb.append("\t\tvideoList[").append(counter).append("].description: ").append(video.description).append(Constants.NL);
            sb.append(Constants.NL);
            counter++;
        }
        return sb.toString();
    }
}

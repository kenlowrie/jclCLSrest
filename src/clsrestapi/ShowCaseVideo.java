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
package clsrestapi;

import java.io.Serializable;

class Roles implements Serializable{
    String director;
    String dp;
    String camera;
    String editor;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Roles)){
            return false;
        }
        
        Roles ri = (Roles)o;
        
        return  director.equals(ri.director) &&
                dp.equals(ri.dp) &&
                camera.equals(ri.camera) &&
                editor.equals(ri.editor);
    }

    @Override
        public String toString(){
        StringBuilder sb = new StringBuilder();
        
        if( !director.isEmpty() ) sb.append("Director: ").append(director).append(", ");
        if( !dp.isEmpty() ) sb.append("DP: ").append(dp).append(", ");
        if( !camera.isEmpty() ) sb.append("Camera: ").append(camera).append(", ");
        if( !editor.isEmpty() ) sb.append("Editor: ").append(editor).append(", ");
        
        return sb.toString();
    }

}
/**
 *
 * @author Ken Lowrie
 */
public class ShowCaseVideo extends Video implements Serializable{
    public String type;
    public Roles roles;
    public String description;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof ShowCaseVideo)){
            return false;
        }
        
        ShowCaseVideo si = (ShowCaseVideo)o;
        
        return  type.equals(si.type) &&
                description.equals(si.description) &&
                roles.equals(si.roles);
    }

    @Override
        public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Type: ").append(type).append(Constants.NL);
        sb.append("Roles: ").append(roles).append(Constants.NL);
        sb.append("Description: ").append(description).append(Constants.NL);
        
        return sb.toString();
    }    
    
}

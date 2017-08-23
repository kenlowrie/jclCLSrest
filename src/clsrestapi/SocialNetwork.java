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

/**
 *
 * @author Ken Lowrie
 */
public class SocialNetwork implements Serializable {
    public String network;
    public String id;
    public String url;
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof SocialNetwork)){
            return false;
        }
        
        SocialNetwork sn = (SocialNetwork)o;
        
        return  network.equals(sn.network) &&
                id.equals(sn.id) &&
                url.equals(sn.url);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("\tAddress:").append(Constants.NL);
        
        sb.append("\tNetwork: ").append(network).append(Constants.NL);
        sb.append("\tID: ").append(id).append(Constants.NL);
        sb.append("\tUrl: ").append(url).append(Constants.NL);
        
        return sb.toString();
    }   
}

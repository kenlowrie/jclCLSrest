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

import jclclsrest.Constants;

/**
 *
 * @author Ken Lowrie
 */
public class Video {
    public String title;
    public String url;
    public String sUrl;
    public String thumb;
    public String frame;
    
    @Override
    public String toString(){
        String s;
        
        s = "\ttitle: " + title + Constants.NL +
            "\turl: " + url + Constants.NL +
            "\tsUrl: " + sUrl + Constants.NL +
            "\tthumb: " + thumb + Constants.NL +
            "\tframe: " + frame + Constants.NL;
        
        return s;
    }
    
}

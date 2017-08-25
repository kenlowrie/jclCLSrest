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

/**
 * This class implements a few helper methods for testing the common API object data.
 * @author Ken Lowrie
 */
public class TestHelpers {
    /**
     * Validate the contents of a dbgObj from an API return call.
     * @param dbgObj Instance of {@link DbgObj} to validate
     * @param apiName The API name being checked
     */
    public static void checkDbgObjInstanceData(DbgObj dbgObj, String apiName){
        assert(dbgObj.parseOK);
        assert(dbgObj.query_string.isEmpty());
        assert(dbgObj.request_uri.equals("/" + apiName + "/"));
        assert(dbgObj.restAPIkeys.get(0).equals(apiName));
        assert(dbgObj.traceMsgQ.isEmpty());
    }
    
    public static void checkApiVerInstanceData(ApiVer apiVer, String apiName){
        
        ApiVer apiVer2 = new ApiVer(apiName, "1.0", "1.0");
        
        assert(apiVer.equals(apiVer2));
    }
    private TestHelpers(){
        
    }
}

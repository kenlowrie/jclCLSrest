/*
 * Copyright 2017 Ken Lowrie <ken@klowrie.net>.
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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ken Lowrie <ken@klowrie.net>
 */
public class OurWorkTest {
    
    public OurWorkTest() {
    }

    /**
     * Test of load method, of class OurWork.
     */
    @Test
    public void testLoad() {
        System.out.println("OurWork.testLoad");
        OurWork instance = new OurWork();
        OurWork result = instance.load();
        assert(result instanceof OurWork);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class OurWork.
     */
    @Test
    public void testEquals() {
        System.out.println("OurWork.testEquals");
        OurWork instance1 = new OurWork().load();
        OurWork instance2 = new OurWork(Constants.WSURL).load();
        boolean expResult = true;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
        assert(instance1 != instance2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class OurWork.
     */
    @Test
    public void testToString() {
        System.out.println("OurWork.testToString");
        OurWork instance = new OurWork().load();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        assert(result.startsWith("---"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testMiscCrap() {
        System.out.println("OurWork.testMiscCrap");
        OurWork instance = new OurWork().load();
        
        System.out.println("OurWork.testMiscCrap : checkDbgObjInstanceData");
        TestHelpers.checkDbgObjInstanceData(instance.dbgObj,Constants.API_OUR_WORK);

        System.out.println("OurWork.testMiscCrap : checkApiVerInstanceData");
        TestHelpers.checkApiVerInstanceData(instance.apiVer,Constants.API_OUR_WORK);

        System.out.println("OurWork.testMiscCrap : checkApiObjInstanceData");
        assert(instance.apiObj.numVideos == 8);
        assert(instance.apiObj.videoList.get(0) instanceof ShowCaseVideo);
    }    
}

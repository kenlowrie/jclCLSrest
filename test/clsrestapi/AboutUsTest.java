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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ken Lowrie
 */
public class AboutUsTest {
    
    public AboutUsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //System.out.println("setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //System.out.println("tearDownClass");
    }
    
    @Before
    public void setUp() {
        //System.out.println("setUp");
    }
    
    @After
    public void tearDown() {
        //System.out.println("tearDown");
    }

    /**
     * Test of load method, of class AboutUs.
     */
    @Test
    public void testLoad() {
        System.out.println("AboutUs.testLoad");
        AboutUs instance = new AboutUs();
        AboutUs result = instance.load();
        assert(result instanceof AboutUs);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class AboutUs.
     */
    @Test
    public void testEquals() {
        System.out.println("AboutUs.testEquals");
        Object o = null;
        AboutUs instance1 = new AboutUs().load();
        AboutUs instance2 = new AboutUs(Constants.WSURL).load();
        boolean expResult = true;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
        assert(instance1 != instance2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class AboutUs.
     */
    @Test
    public void testToString() {
        System.out.println("AboutUs.testToString");
        AboutUs instance = new AboutUs().load();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        assert(result.startsWith("---"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testMiscCrap() {
        System.out.println("AboutUs.testMiscCrap");
        AboutUs instance = new AboutUs().load();
        
        System.out.println("AboutUs.testMiscCrap : checkDbgObjInstanceData");
        TestHelpers.checkDbgObjInstanceData(instance.dbgObj,Constants.API_ABOUT_US);

        System.out.println("AboutUs.testMiscCrap : checkApiVerInstanceData");
        TestHelpers.checkApiVerInstanceData(instance.apiVer,Constants.API_ABOUT_US);

        System.out.println("AboutUs.testMiscCrap : checkApiObjInstanceData");
        String expResult = "";
        assert(instance.apiObj.aboutus.startsWith("Although Cloudy Logic")); 
        
    }
    
}

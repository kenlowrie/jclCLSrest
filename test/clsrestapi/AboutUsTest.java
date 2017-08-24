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
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of load method, of class AboutUs.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        AboutUs instance = new AboutUs();
        AboutUs expResult = null;
        AboutUs result = instance.load();
        //assertEquals(expResult, result);
        assert(result instanceof AboutUs);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class AboutUs.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
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
        System.out.println("toString");
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
        System.out.println("miscCrap");
        AboutUs instance = new AboutUs().load();
        String expResult = "";
        assert(instance.apiObj.aboutus.startsWith("Although Cloudy Logic")); 
        
        ApiVer apiVer = new ApiVer(Constants.API_ABOUT_US, "1.0", "1.0");
        
        assert(apiVer.equals(instance.apiVer));
        
        assert(instance.dbgObj.parseOK);
    }
    
}

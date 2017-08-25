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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ken Lowrie
 */
public class ContactInfoTest {
    
    public ContactInfoTest() {
    }

    /**
     * Test of equals method, of class ContactInfo.
     */
    @Test
    public void testEquals() {
        System.out.println("ContactInfo.testEquals");
        ContactInfo instance1 = new ContactInfo().load();
        ContactInfo instance2 = new ContactInfo(Constants.WSURL).load();
        boolean expResult = true;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
        assert(instance1 != instance2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class ContactInfo.
     */
    @Test
    public void testLoad() {
        System.out.println("ContactInfo.testLoad");
        ContactInfo instance = new ContactInfo();
        ContactInfo result = instance.load();
        assert(result instanceof ContactInfo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ContactInfo.
     */
    @Test
    public void testToString() {
        System.out.println("ContactInfo.testToString");
        ContactInfo instance = new ContactInfo().load();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
        assert(result.startsWith("---"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testMiscCrap() {
        System.out.println("ContactInfo.testMiscCrap");
        ContactInfo instance = new ContactInfo().load();
        
        System.out.println("ContactInfo.testMiscCrap : checkDbgObjInstanceData");
        TestHelpers.checkDbgObjInstanceData(instance.dbgObj,Constants.API_CONTACT_INFO);

        System.out.println("ContactInfo.testMiscCrap : checkApiVerInstanceData");
        TestHelpers.checkApiVerInstanceData(instance.apiVer,Constants.API_CONTACT_INFO);

        System.out.println("ContactInfo.testMiscCrap : checkApiObjInstanceData");
        String expResult = "";
        assert(instance.apiObj.location.startsWith("Cloudy Logic Studios")); 
        assert(instance.apiObj.address instanceof Address);
        assert(instance.apiObj.email.equals("info@cloudylogic.com"));
        assert(instance.apiObj.phone.equals("512.710.7257"));
        assert(instance.apiObj.socialNetworks.size() == 3);
        assert(instance.apiObj.socialNetworks.get(0) instanceof SocialNetwork);
        
    }
}

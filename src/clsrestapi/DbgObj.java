

package clsrestapi;

import java.util.List;

/**
 * This class implements the JSON dbgObj element for Java Clients.
 * 
 * @author Ken Lowrie {@code <mailto:ken@klowrie.net>}
 */
public class DbgObj {
    /**
     * parseOK indicates whether the server was able to parse the API name and parameters.
     */
    public boolean parseOK;
    public List<String> traceMsgQ;
    public List<String> restAPIkeys;
    public String request_uri;
    public String query_string;
    
    /**
     * Generates a printable version of the dbgObj object.
     * 
     * @return String - This is a formatted version of the object data.
     */
    @Override
    public String toString(){
        String s;
        
        s = "\tparseOK: " + parseOK + Constants.NL +
            "\trequest_uri: " + request_uri + Constants.NL +
            "\tquery_string: " + query_string + Constants.NL +
            "\trestAPIkeys: " + restAPIkeys + Constants.NL +
            "\ttraceMsgQ: " + traceMsgQ + Constants.NL;
        
        return s;
    }
}


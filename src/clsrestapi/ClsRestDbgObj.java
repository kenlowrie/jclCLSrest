/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclclsrest;

import java.util.List;

/**
 * This class implements the JSON dbgObj element for Java Clients.
 * @author Ken Lowrie <ken@klowrie.net>
 */
class ClsRestDbgObj {
    public boolean parseOK;
    public List<String> traceMsgQ;
    public List<String> restAPIkeys;
    public String request_uri;
    public String query_string;
    
    /**
     * Generates a printable version of the dbgObj object.
     * 
     * @return String
     */
    @Override
    public String toString(){
        String s;
        
        s = "\tparseOK: " + parseOK + Consts.NEW_LINE +
            "\trequest_uri: " + request_uri + Consts.NEW_LINE +
            "\tquery_string: " + query_string + Consts.NEW_LINE +
            "\trestAPIkeys: " + restAPIkeys + Consts.NEW_LINE +
            "\ttraceMsgQ: " + traceMsgQ + Consts.NEW_LINE;
        
        return s;
    }
}


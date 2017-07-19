/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclclsrest;

/**
 *
 * @author ken
 */
public class Consts {
  
  public static final String NEW_LINE = System.getProperty("line.separator");
  
  public static final String EMPTY_STRING = "";
  public static final String SPACE = " ";
  public static final String TAB = "\t";
  public static final String SINGLE_QUOTE = "'";
  public static final String PERIOD = ".";
  public static final String DOUBLE_QUOTE = "\"";

  // PRIVATE //

  /**
   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
   and so on. Thus, the caller should be prevented from constructing objects of 
   this class, by declaring this private constructor. 
  */
  private Consts(){
    //this prevents even the native class from 
    //calling this ctor as well :
    throw new AssertionError();
  }
}


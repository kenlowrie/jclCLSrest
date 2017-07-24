/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clsrestapi;

/**
 * The caller references these constants using <tt>Constants.WSURL</tt>.
 *
 */
public class Constants {
  
  public static final String NL = System.getProperty("line.separator");
  public static final String WSURL = "http://api.cloudylogic.com";
  public static final String API_ABOUT_US = "about-us";
  public static final String API_CONTACT_INFO = "contact-info";
  public static final String API_REELS = "reels";
  public static final String API_OUR_WORK = "our-work";
  public static final String API_VERSIONS = "versions";

  /**
   * Prevent the caller from constructing objects of this class.
  */
  private Constants(){
  }
}


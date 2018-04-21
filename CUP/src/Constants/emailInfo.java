/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

/**
 *
 * @author bickerstaff2
 */
public class emailInfo {
    
    public static final String CONTACTEMAIL = "cyberunderproj@gmail.com";
    public static final String SENDTO = "To: ";
    public static final String FROM = "From: cyberunderproj@gmail.com";
    public static final String SUBJECT = "Subject: Your files have been accessed";
    public static final String INITIALLINE = "Warning. Your files have been accessed.";
    public static final String FILESEFFECTED = "The following file(s) have been accessed: ";
    public static final String FILEUNDERATTACK = "The file(s) have been secured. "
            + "If this access is unauthorized contact your system administrator. "
            + "If this access is authorized then please lift the file ban";
    public static final String FILECOMPROMISED = "The file(s) were accessed and potentially altered."
            + "Check your files to minimize potential damages.";
    public static final String EMAILFAIL = "The attack progress was not specified. "
            + "Please double check your files to determine if an attack occured.";
    
    public static final String EMAILATTACK = "UNDERATTACK";
    public static final String EMAILCOMPROMISED = "COMPROMISED";
    public static final String EMAILPROTECTED = "PROTECTED";
}

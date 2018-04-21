/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Entities.email;
import Constants.emailInfo;

import java.io.PrintStream;

/**
 *
 * @author bickerstaff2
 */
public class SendEmail {

    public SendEmail() {
    }

    public static void emailer(email newEmail) throws Exception {
        String fileName = newEmail.getFileName();
        String recipient = newEmail.getRecipient();
        String fileStatus = newEmail.getStatus();

        emailConstructor(fileStatus, fileName, recipient);

    }

    private static void emailConstructor(String status, String fileN, String recip) throws Exception {
        Process p = new ProcessBuilder("ssmtp", "cyberunderproj@gmail.com").start();
        PrintStream out = new PrintStream(p.getOutputStream());
        out.println(emailInfo.SENDTO + recip);
        out.println(emailInfo.FROM);
        out.println(emailInfo.SUBJECT);
        out.println();
        out.println(emailInfo.INITIALLINE);
        out.println(emailInfo.FILESEFFECTED);
        out.println(fileN);
        switch (status) {
            case "UNDERATTACK":
                out.println(emailInfo.FILEUNDERATTACK);
                break;
            case "COMPROMISED":
                out.println(emailInfo.FILECOMPROMISED);
                break;
            default:
                out.println(emailInfo.EMAILFAIL);
                break;
        }
        out.close();
        int exitCode = p.waitFor();
        assert exitCode == 0;
        System.out.println(exitCode);
    }
}

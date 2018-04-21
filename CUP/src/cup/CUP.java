/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cup;

import Accessors.*;
import Entities.*;
import Constants.*;

/**
 *
 * @author bickerstaff2
 */
public class CUP {

    boolean aip = false;
    boolean edited = false;
    boolean emailSent = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        specifyFiles protectedFile1 = new specifyFiles("serverfile.txt", "/home/bickerstaff2/MyServer",
                permissions.ORIGPERMS, "664");
        email newEmail1 = new email(emailInfo.EMAILPROTECTED, "cyberunderproj@gmail.com",
                protectedFile1.getName());

        mothership(newEmail1, protectedFile1);
    }

    private static void mothership(email newEmail1, specifyFiles protectedFile1) {
        boolean emailSentAttack = false;
        boolean emailSentEdited = false;
        int counter = 0;
        try {
            for (;;) {
                monitoropen.monitor(newEmail1, protectedFile1);
                if (!emailSentAttack && newEmail1.getStatus().contains(emailInfo.EMAILATTACK)) {
                    SendEmail.emailer(newEmail1);
                    counter = 0;
                    emailSentAttack = true;
                } else {
                    counter++;
                }
                if (counter == 5) {
                    findsweeper.sweeper(newEmail1, protectedFile1);
                    if (!emailSentEdited && newEmail1.getStatus().contains(emailInfo.EMAILATTACK)) {
                        SendEmail.emailer(newEmail1);
                        emailSentEdited = true;
                    }
                    counter = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

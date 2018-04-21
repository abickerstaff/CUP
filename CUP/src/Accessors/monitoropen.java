/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Entities.*;
import Constants.emailInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author bickerstaff2
 */
public class monitoropen {

    public monitoropen() {
    }

    public static void monitor(email emailer, specifyFiles protectedFile) {
        try {

            ProcessBuilder builder = new ProcessBuilder();
            builder.command("/bin/sh", "-c", "lsof | grep /home/bickerstaff2/MyServer");
            Process process = builder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(protectedFile.getName())) {
                    emailer.setStatus(emailInfo.EMAILATTACK);
                }
                System.out.println(line);

            }

            int exitCode = process.waitFor();
            assert exitCode == 0;
            System.out.println(exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

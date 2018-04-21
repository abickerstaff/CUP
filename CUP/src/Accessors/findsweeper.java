/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Entities.*;
import Constants.emailInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author bickerstaff2
 */
public class findsweeper {

    public findsweeper() {
    }
    
    public static void sweeper(email emailer, specifyFiles protectFile) {
        try {
            String fileName = protectFile.getName();
            
            ProcessBuilder builder = new ProcessBuilder();            
            builder.command("find", ".", "-mmin", "-5"); //Find files in the directory changed in past 5 min
            builder.directory(new File("/home/bickerstaff2/MyServer"));
            Process process = builder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("./" + fileName)) {
                    emailer.setStatus(emailInfo.EMAILCOMPROMISED);
                }
                System.out.println(line);
                
            }
            int exitCode = process.waitFor();
            assert exitCode == 0;
            System.out.println(exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sent");
    }
        
    
}

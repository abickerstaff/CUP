/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Entities.specifyFiles;
import Constants.permissions;

/**
 *
 * @author bickerstaff2
 */
public class changeperms {

    public changeperms() {
    }
    
    public static void permissionChecker(specifyFiles protectedFile) throws Exception{
        specifyFiles fileUnderAttack = protectedFile;
        
        if (fileUnderAttack.getCurrentPerms().contains(permissions.READONLY)) {
            return;
        }
        else {
            changer(fileUnderAttack);
            protectedFile.setCurrentPerms(permissions.READONLY);
        }
        
        
    }
    private static void changer(specifyFiles fileAttacked) throws Exception{
        String currentPerms = fileAttacked.getCurrentPerms();
        String readOnly = permissions.READONLY;
        String path = fileAttacked.getPath();
        
        
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("chmod", readOnly, path);
        Process process = builder.start();
        
        int exitCode = process.waitFor();
        assert exitCode == 0;
        System.out.println(exitCode);
    }
}

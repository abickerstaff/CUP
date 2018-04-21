/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author bickerstaff2
 */
public class specifyFiles {

    private String path;
    private String name;
    private String currentPerms;
    private String initialPerms;
    
    public specifyFiles() {
    }
    
    public specifyFiles(String name, String path, String currentPerms, String initialPerms) {
        this.path = path;
        this.name = name;
        this.currentPerms = currentPerms;
        this.initialPerms = initialPerms;
    }

    public String getInitialPerms() {
        return initialPerms;
    }

    public void setInitialPerms(String initialPerms) {
        this.initialPerms = initialPerms;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the currentPerms
     */
    public String getCurrentPerms() {
        return currentPerms;
    }

    /**
     * @param currentPerms the currentPerms to set
     */
    public void setCurrentPerms(String currentPerms) {
        this.currentPerms = currentPerms;
    }

    
}

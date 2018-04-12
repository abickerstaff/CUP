/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileObj;

/**
 *
 * @author bickerstaff2
 */
public class specifyFiles {

    private String path;
    private String name;
    private String currentPerms;
    private String origPerms;
    
    public specifyFiles() {
    }
    
    public specifyFiles(String path, String name, String currentPerms, String origPerms) {
        this.path = path;
        this.name = name;
        this.currentPerms = currentPerms;
        this.origPerms = origPerms;
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

    /**
     * @return the origPerms
     */
    public String getOrigPerms() {
        return origPerms;
    }

    /**
     * @param origPerms the origPerms to set
     */
    public void setOrigPerms(String origPerms) {
        this.origPerms = origPerms;
    }
    
}

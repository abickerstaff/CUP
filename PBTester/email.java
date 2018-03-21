
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bickerstaff2
 */
public class email {

    public static void emailer(String name, String emailType) throws Exception {
        Process p = new ProcessBuilder("ssmtp", "cyberunderproj@gmail.com").start();
        PrintStream out = new PrintStream(p.getOutputStream());
        String fileToSend = "";
        int pswd =0;
        if (emailType.equals("compromised")) {
            fileToSend = "compmsg.txt";
        }
        else if (emailType.equals("inProgress")) {
            fileToSend = "activemsg.txt";
            pswd = 123;
        } 
        
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileToSend)));
        int lineCount = 0;
        while ((line = in.readLine()) != null) {
            lineCount++;
            if (lineCount != 8) {
                out.println(line);
            }
            if (lineCount == 5) {
                out.print(name);
            }
            if (lineCount == 8 && fileToSend.equals("inProgress")) {
                out.println(line + pswd);
            }
        }
        out.close();
        in.close();

        int exitCode = p.waitFor();
        assert exitCode == 0;
        System.out.println(exitCode);

    }
}

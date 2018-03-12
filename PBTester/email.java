
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
 
    public static void main(String[] args) throws Exception{
        Process p = new ProcessBuilder("ssmtp", "cyberunderproj@gmail.com").start();
        PrintStream out = new PrintStream(p.getOutputStream());
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("msg.txt")));
        while ((line = in.readLine()) != null) {
            out.println(line);
        }
        out.close();
        in.close();

        int exitCode = p.waitFor();
        assert exitCode == 0;
        System.out.println(exitCode);

    }
}

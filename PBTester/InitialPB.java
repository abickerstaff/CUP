

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bickerstaff2
 */
public class InitialPB extends email{

    public static void main(String[] args) throws Exception {
        ProcessBuilder builder = new ProcessBuilder();
        //builder.command(/*"sh", "-c", */"ls"); //List files in directory
        builder.command("find", ".", "-mmin", "-20"); //Find files in the directory changed in past 5 min
        /*
                Needs to read in files changed in directory in last X minutes
                If a file is one specified by user then it will send alert
                Essentially a fail safe if someone backdoors the system or puts
                new file into directory with files being monitored
         */
        //builder.command("tail", "-f", "serverfile.txt"); //Shows end of file specified      

        builder.directory(new File("/home/bickerstaff2/MyServer"));
        Process process = builder.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("./serverfile.txt")) {
                String name = "serverfile.txt";
                emailer(name, "compromised");
                System.out.println(line);
            } else {
                System.out.println(line);
            }
        }
        int exitCode = process.waitFor();
        assert exitCode == 0;
        System.out.println(exitCode);
    }

}


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bickerstaff2
 */
public class InitialPB {
    
    public static void main(String[] args) throws Exception{
        //builder.command(/*"sh", "-c", */"ls"); //List files in directory
        builder.command("find", ".", "-mmin", "-5"); //Find files in the directory changed in past 5 min
            /*
                Needs to read in files changed in directory in last X minutes
                If a file is one specified by user then it will send alert
                Essentially a fail safe if someone backdoors the system or puts
                new file into directory with files being monitored
            */
        //builder.command("tail", "-f", "serverfile.txt"); //Shows end of file specified
        builder.directory(new File("/home/bickerstaff2/MyServer"));
        Process process = builder.start();
        StreamGobbler sG = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(sG);
        int exitCode = process.waitFor();
        assert exitCode == 0;
        
    }

    private static class StreamGobbler implements Runnable{
        private InputStream iS;
        private Consumer<String> cons;
        
        public StreamGobbler(InputStream iS, Consumer<String> cons) {
            this.iS = iS;
            this.cons = cons;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(iS)).lines().forEach(cons);
             
        }
    }
}

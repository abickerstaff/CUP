
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
                emailer();
            } else {
                System.out.println(line);
            }
        }
        /* StreamGobbler sG = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(sG); */
        int exitCode = process.waitFor();
        assert exitCode == 0;
        System.out.println(exitCode);
    }
/*
    private static class StreamGobbler implements Runnable {

        private InputStream iS;
        private Consumer<String> cons;

        public StreamGobbler(InputStream iS, Consumer<String> cons) throws Exception {
            this.iS = iS;
            this.cons = cons;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(iS)).lines().forEach(cons);

        }
    }
*/

    public static void emailer() throws Exception {

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
        System.out.println("run");
    }
}

package instance.engine;

import instance.util.Util;
import java.io.Console;
import java.io.IOException;

public class Derby implements Engine {

    private static final int PORT = 1527;
    private static final String HOST = "localhost";

    private Console console;

    public Derby() {
        console = System.console();
    }

    @Override
    public void start() {
        try {
            Runtime.getRuntime().exec("java -jar " + "\"" + Util.jdkPath()
                    + "\\db\\lib\\derbyrun.jar" + "\" server start -p " + PORT);
        } catch (IOException e) {
            console.writer().println(e.getMessage());
        }
    }

    @Override
    public void stop() {
        try {
            Runtime.getRuntime().exec("java -jar " + "\"" + Util.jdkPath()
                    + "\\db\\lib\\derbyrun.jar" + "\" server shutdown -p " + PORT);
        } catch (IOException e) {
            console.writer().println(e.getMessage());
        }
    }

    @Override
    public void info() {
        console.writer().println(System.lineSeparator() + HOST + ":" + PORT);
    }

}

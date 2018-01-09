package instance.engine;

import org.hsqldb.Server;

import java.io.Console;
import java.net.InetAddress;

public class HyperSQL implements Engine {

    private static final int PORT = 9001;
    private static final String HOST = "localhost";
    private static final String DBNAME = "test";

    private Console console;
    private Server server;

    public HyperSQL() {
        server = new Server();
        console = System.console();
    }

    @Override
    public void start() {
        try {
            server.setAddress(InetAddress.getByName(HOST).getHostAddress());
            server.setPort(PORT);
            server.setDatabaseName(0, DBNAME);
            server.setDatabasePath(0, "mem:" + DBNAME);
            server.setSilent(true);
            server.start();
        } catch (Exception e) {
            console.writer().println(e.getMessage());
        }
    }

    @Override
    public void stop() {
        try {
            server.shutdown();
        } catch (Exception e) {
            console.writer().println(e.getMessage());
        }
    }

    @Override
    public void info() {
        console.writer().println(System.lineSeparator() + HOST + ":" + PORT);
    }

}

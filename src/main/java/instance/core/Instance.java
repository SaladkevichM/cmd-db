package instance.core;

import instance.engine.Derby;
import instance.engine.HyperSQL;
import instance.engine.Engine;
import instance.util.Util;

import java.io.Console;

/**
 * any_db_instance main class
 *
 */
public class Instance {

    public static void main(String[] args) {

        Console c = System.console();
        if (c == null) {
            System.exit(1);
        }
        c.writer().println("" + System.lineSeparator() + Util.getProperty("alert"));

        EngineType type = null;
        while (type == null) {
            String chosen =
                    c.readLine(Util.getProperty("types") + "(" + Util.getEngineTypes() + "): ");
            type = EngineType.fromString(chosen);
        }

        Engine engine = null;
        switch (type) {
            case DERBY:
                engine = new Derby();
                break;
            case HYPERSQL:
                engine = new HyperSQL();
                break;
            default:
                engine = new Derby();
        }

        engine.start();
        engine.info();

        String stop = "";
        do {
            stop = c.readLine(System.lineSeparator() + Util.getProperty("shutdown") + " ...");
        } while (!stop.equals(""));

        engine.stop();
    }

}

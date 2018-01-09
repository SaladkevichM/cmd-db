package instance.util;

import instance.core.EngineType;

import java.io.InputStream;
import java.util.Properties;

/**
 * Some utility functions
 *
 */
public final class Util {

    private static final String DEFAULT_LANG = "lang.en";

    public static String jdkPath() {
        return "C:\\\\Program Files\\Java\\jdk" + System.getProperty("java.version");
    }

    public static String getEngineTypes() {

        StringBuilder result = new StringBuilder();
        EngineType[] vals = EngineType.values();
        result.append(System.lineSeparator());
        for (EngineType v : vals) {
            result.append(v.ordinal()).append(" - ").append(v.name())
                    .append(System.lineSeparator());
        }
        return result.toString();

    }

    private Util() {

    }

    /**
     * Get property from lang.* files
     * 
     * @throws Exception
     * 
     */
    public static String getProperty(String name) {

        Properties prop = new Properties();
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream(getLang())) {

            prop.load(input);
            return prop.getProperty(name);

        } catch (Exception e) {
            System.console().writer().println(e.getMessage());
        }

        return "";

    }

    private static String getLang() {
        return DEFAULT_LANG;
    }

}

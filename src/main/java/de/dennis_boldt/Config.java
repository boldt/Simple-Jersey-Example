package de.dennis_boldt;

/**
 * The configuration
 *
 * @author Dennis Boldt
 *
 */
public class Config {

    public static final String HOSTNAME = "localhost";
    public static final Integer PORT = 9999;
    public static final String JAXRS_RESOURCES = "de.dennis_boldt";

    public static String getBaseURL(Integer port) {
        if(port == null) {
            port = Config.PORT;
        }
        StringBuilder sb = new StringBuilder("http://");
        sb.append(Config.HOSTNAME).append(":").append(String.valueOf(port)).append("/");
        return sb.toString();
    }
}

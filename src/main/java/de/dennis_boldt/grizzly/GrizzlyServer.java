package de.dennis_boldt.grizzly;

import java.util.HashMap;
import java.util.Map;

import com.sun.jersey.api.container.grizzly2.GrizzlyWebContainerFactory;

import de.dennis_boldt.Config;

public class GrizzlyServer {

    public GrizzlyServer(int port) {
        final Map<String, String> init_params = new HashMap<String, String>();
        init_params.put("com.sun.jersey.config.property.packages", Config.JAXRS_RESOURCES);
        init_params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        System.out.println("Starting grizzly...");
        try {
            String baseurl = Config.getBaseURL(port);
            GrizzlyWebContainerFactory.create(baseurl, init_params);
            System.out.println("Grizzly server started: " + baseurl);
            System.in.read();
            System.out.println("Stop server");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = Config.PORT;
        }

        new GrizzlyServer(port);
    }
}
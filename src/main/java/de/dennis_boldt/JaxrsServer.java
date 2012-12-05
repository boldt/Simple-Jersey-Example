package de.dennis_boldt;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.devsprint.jersey.api.container.netty.JerseyHandler;
import com.sun.jersey.api.container.ContainerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;



public class JaxrsServer {

    public void start(Integer port) {
        // Configure the server
        ServerBootstrap bootstrap = new ServerBootstrap(
            new NioServerSocketChannelFactory(
                    Executors.newCachedThreadPool(),
                    Executors.newCachedThreadPool()
            ));

        bootstrap.setPipelineFactory(new JaxrsServerChannelPipelineFactory(getJerseyHandler(port)));
        bootstrap.bind(new InetSocketAddress(port));

        System.out.println("JAX-RS server started on port " + port);
    }

    private JerseyHandler getJerseyHandler(int port) {

        final Map<String, Object> inti_params = new HashMap<String, Object>();
        inti_params.put("com.devsprint.jersey.api.container.netty.baseUri", Config.getBaseURL(port));
        inti_params.put("com.sun.jersey.config.property.packages", Config.JAXRS_RESOURCES);
        inti_params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        ResourceConfig resourceConfig = new PackagesResourceConfig(inti_params);

        // Generate the Jersey handler
        return ContainerFactory.createContainer(JerseyHandler.class, resourceConfig);
    }

    public static void main(String[] args) {
        Integer port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = Config.PORT;
        }
        JaxrsServer server = new JaxrsServer();
        server.start(port);
    }
}

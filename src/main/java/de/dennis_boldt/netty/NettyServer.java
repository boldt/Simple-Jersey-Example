package de.dennis_boldt.netty;
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

import de.dennis_boldt.Config;



public class NettyServer {

    private String baseurl = null;

    public NettyServer(Integer port) {
        // Configure the server
        ServerBootstrap bootstrap = new ServerBootstrap(
            new NioServerSocketChannelFactory(
                    Executors.newCachedThreadPool(),
                    Executors.newCachedThreadPool()
            ));

        this.baseurl = Config.getBaseURL(port);

        bootstrap.setPipelineFactory(new NettyServerChannelPipelineFactory(getJerseyHandler(port)));
        bootstrap.bind(new InetSocketAddress(port));

        System.out.println("Netty server started: " + baseurl);
    }

    private JerseyHandler getJerseyHandler(int port) {

        final Map<String, Object> init_params = new HashMap<String, Object>();
        init_params.put("com.devsprint.jersey.api.container.netty.baseUri", this.baseurl);
        init_params.put("com.sun.jersey.config.property.packages", Config.JAXRS_RESOURCES);
        init_params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        ResourceConfig resourceConfig = new PackagesResourceConfig(init_params);

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
        new NettyServer(port);
    }
}

package de.dennis_boldt;

import de.dennis_boldt.grizzly.GrizzlyServer;
import de.dennis_boldt.netty.NettyServer;

public class Main {

    public static void main(String[] args) {
        int port = 0;
        if (args.length > 1) {
            port = Integer.parseInt(args[0]);
        } else {
            port = Config.PORT;
        }

        if(args[0] == "netty") {
            new NettyServer(port);
        } else if(args[0] == "grizzly") {
            new GrizzlyServer(port);
        } else {
            throw new Error("Unknown Server");
        }

    }

}

package de.dennis_boldt;

import de.dennis_boldt.grizzly.GrizzlyServer;
import de.dennis_boldt.netty.NettyServer;

public class Main {

    public static void main(String[] args) {
        int port = 0;

        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        } else {
            port = Config.PORT;
        }

        if(args.length > 0 && "netty".equals(args[0])) {
            new NettyServer(port);
        } else if(args.length > 0 && "grizzly".equals(args[0])) {
            new GrizzlyServer(port);
        } else {
            throw new Error("Unknown Server");
        }

    }

}

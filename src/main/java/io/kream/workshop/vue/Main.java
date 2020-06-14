package io.kream.workshop.vue;

import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.docs.DocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final ServerBuilder sb = Server.builder();

        final Server server = sb
                .http(8080)
                .serviceUnder("/docs", new DocService())
                .build();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop();
            log.info("Server has been stopped.");
        }));

        server.start().join();
    }
}

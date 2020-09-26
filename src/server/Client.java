package server;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

public class Client {

    public static void main(String[] args) {
        String request = "DELETE__Roman";
        System.out.println("Client started: " + LocalDateTime.now());
        for (int i = 0; i < 10; i++) {
            ThreadedClient threadedClient = null;
            try {
                threadedClient = new ThreadedClient(new Socket("127.0.0.1", 2107),request + i);
            } catch (IOException e) {
                System.err.println(e);
            }
            threadedClient.start();
        }
        System.out.println("Client stopped: " + LocalDateTime.now());
    }

}

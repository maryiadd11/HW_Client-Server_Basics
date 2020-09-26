package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2107);
        System.out.println("Server started");
        while(true) {
            Socket client = serverSocket.accept();
            ThreadedServer threadedServer = new ThreadedServer(client);
            threadedServer.start();
        }
    }

}

package server;

import java.io.*;
import java.net.Socket;

public class ThreadedServer extends Thread {

    Socket client;

    public ThreadedServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            String request = br.readLine();
            System.out.println(String.format("Server received request [%s]",request));
            Thread.sleep(2000);
            String response = handleRequestCommand(request);
            bw.write(response);
            bw.newLine();
            bw.flush();
            System.out.println(String.format("Server sent response [%s]",response));
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }

    }

    private String handleRequestCommand(String request) {
        String[] arrayRequest = request.split("__");
        String method = arrayRequest[0];
        String requestBody = arrayRequest[1];
        switch (method) {
            case "CONNECT" : return String.format("Connected to %s", requestBody);
            case "GET" : return String.format("Hello, %s", requestBody);
            case "PUT" : return String.format("Updated %s", requestBody);
            case "DELETE" : return String.format("Deleted %s", requestBody);
            default : return "ERROR 400 Bad request";
        }
    }
}

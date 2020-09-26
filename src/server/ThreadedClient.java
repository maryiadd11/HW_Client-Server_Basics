package server;

import java.io.*;
import java.net.Socket;

public class ThreadedClient extends Thread {

    private Socket client;
    private String request;

    public ThreadedClient(Socket client, String request) {
        this.client = client;
        this.request = request;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(request);
            bw.newLine();
            bw.flush();
            System.out.println(String.format("Sent request [%s]", request));
            String response = br.readLine();
            System.out.println(String.format("Received request [%s]", response));
            client.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

}

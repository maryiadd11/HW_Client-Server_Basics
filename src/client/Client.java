package client;

import entity.Request;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("google.com", 80);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        Request request1 = new Request("GET");
        request1.addHeaders("Host", "www.google.com");
        request1.addHeaders("Content-Type", " text/plain;");
        request1.addHeaders("charset", "UTF-8");
        System.out.println(request1); //для вывода правильности запроса
        os.write(request1.toString().getBytes());
        os.flush();
        int charCode = 0;
        StringBuilder endTrigger = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("response.html"))) { //запись результата в файл
            while((charCode = is.read()) != -1) {
                bw.write((char) charCode);
                endTrigger.append((char) charCode);
                if (endTrigger.toString().equals("</html>")) {
                    break;
                }
            }
        }
        client.close();
    }
}

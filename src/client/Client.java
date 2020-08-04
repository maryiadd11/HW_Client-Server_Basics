package client;

import entity.Request;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("google.com", 80);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        Request requestGet = new Request("GET");
        requestGet.addHeaders("Host", "www.google.com");
        requestGet.addHeaders("Content-Type", " text/plain;");
        requestGet.addHeaders("charset", "UTF-8");
        System.out.println(requestGet); //для вывода правильности запроса
        os.write(requestGet.toString().getBytes());
        os.flush();
        int charCode = 0;
        StringBuilder endTrigger = new StringBuilder();
        File file = new File ("response.html");
        try (OutputStream out = new FileOutputStream(file)) { //запись результата в файл
            while((charCode = is.read()) != -1) {
                out.write((char) charCode);
                endTrigger.append((char) charCode);
                if (endTrigger.toString().equals("</html>")) {
                    break;
                }
            }
        }
        client.close();
    }

}

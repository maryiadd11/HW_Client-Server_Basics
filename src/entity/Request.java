package entity;

import java.util.HashMap;


public class Request {

    private String method;
    private final String protocol = " / HTTP/1.1";
    private HashMap<String, String> headers = new HashMap<>();
    private String body;

    public Request(String method, HashMap<String, String> headers, String body) {
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    public Request(String method, HashMap<String, String> headers) {
        this.method = method;
        this.headers = headers;
    }

    public Request(String method) {
        this.method = method;
    }

    public Request() {
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void addHeaders (String name, String value) {
        headers.put(name, value);
    }



    @Override
    public String toString() {
        return method + protocol + "\r\n" + headers.toString() + body + "\r\n\r\n";
    }
}

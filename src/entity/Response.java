package entity;

public class Response {

    private String header;
    private String body;

    public Response(String header, String body) {
        this.header = header;
        this.body = body;
    }

    public Response() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

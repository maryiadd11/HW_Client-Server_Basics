package entity;

public class Response {

    private String responseCode;
    private String responseDescription;
    private String header;
    private String body;

//201 - Response code, Created - Response description


    public Response(String responseCode, String responseDescription, String header, String body) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.header = header;
        this.body = body;
    }

    public Response() {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
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

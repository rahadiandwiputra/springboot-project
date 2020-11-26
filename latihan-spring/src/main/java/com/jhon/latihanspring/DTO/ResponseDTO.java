package com.jhon.latihanspring.DTO;

public class ResponseDTO<T> {
    private int statusCode;
    private T body;
    private String status;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return "statusCode: "+this.statusCode+ "\n" + "body: "+this.body+"\n status: "+this.status;
    }
}

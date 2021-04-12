package com.test.wx_auth.exceptionhandler;



public class UnauthorizedException extends RuntimeException {

    private String msg;

    public UnauthorizedException(String msg) {
        this.msg=msg;
    }

    @Override
    public String toString() {
        return "UnauthorizedException{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

package com.bin.yihai.common.config;

public enum ResultCode {
    SUCCESS(200),FAIL(400);
    private int code;
    private ResultCode(int v) {
        code = v;
    }
    public int getCode(){
        return code;
    }
}

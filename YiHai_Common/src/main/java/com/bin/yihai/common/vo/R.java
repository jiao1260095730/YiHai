package com.bin.yihai.common.vo;

import com.bin.yihai.common.config.ResultCode;
import lombok.Data;

@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public static R ok(String msg, Object obj) {
        R r = new R();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }
    public static R ok(Object obj) {
        return ok("OK", obj);
    }
    public static R ok(){
        return ok(null);
    }
    public static R fail(String msg){
        R r = new R();
        r.setCode(ResultCode.FAIL.getCode());
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
    public static R fail() {
        return fail("FAIL");
    }
    public static R setR(boolean success, Object obj) {
        if (success) {
            return R.ok(obj);
        }else {
            return R.fail();
        }
    }

}

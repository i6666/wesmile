package com.wesmile.base;

import com.wesmile.enums.ErrorMsgEnum;

/**
 * 返回消息
 * Created by zma on 2019/06/11
 */
public class ResultMsg {

    public static final int ResultCode_OK = 200;
    public static final int ResultCode_Err = 1001;
    public static final String  successMsg = "success";

    private int code;
    private String msg;
    private Object data = null;

    public ResultMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultMsg() {
    }

    public static ResultMsg setErrorMsg(ErrorMsgEnum errorMsgEnum){
        return new ResultMsg(errorMsgEnum.getCode(),errorMsgEnum.getDesc());
    }
    public static ResultMsg setSuccessMsg(Object data){
        return new ResultMsg(ResultCode_OK,successMsg,data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

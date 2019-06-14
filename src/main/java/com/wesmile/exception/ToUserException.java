package com.wesmile.exception;

import com.wesmile.base.ErrorCodeGeneral;

/**
 * 对用户展示的异常
 * Created by zma on 2019/06/11
 */
public class ToUserException  extends RuntimeException  {

    private String errorCode = ErrorCodeGeneral.RESULT_CODE_ERR_MSG;

    public String errorField = null;

    public ToUserException(String message, String code, String errorField) {
        super(message);
        this.errorCode = code;
        this.errorField = errorField;
    }

    public ToUserException(String message, String errorField) {
        super(message);
        this.errorField = errorField;
    }

    public ToUserException(String message) {
        super(message);
    }


}

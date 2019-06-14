package com.wesmile.enums;

public enum ErrorMsgEnum
    {
        SYSTEM_ERROR("系统异常",10001),
        PARAM_ERROR("参数异常",10002);

        private String desc;
        private int code;
        //构造方法
        private ErrorMsgEnum(String desc, int code)
        {
            this.desc =desc;
            this.code=code;
        }

        public String getDesc() {
            return desc;
        }

        public int getCode() {
            return code;
        }
    }
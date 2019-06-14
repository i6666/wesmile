package com.wesmile.util;


import com.alibaba.fastjson.JSON;
import com.wesmile.base.ResultMsg;
import com.wesmile.enums.ErrorMsgEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zma on 2019/06/11
 */
public class ServletUtil {

    private static void writeString(String str, HttpServletResponse res) {
        initResponse(res);
        PrintWriter out;
        try {
            out = res.getWriter();
            out.write(str);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void returnSuccessMsg(Object data, HttpServletResponse response) {
        ServletUtil.writeString(JSON.toJSONString(ResultMsg.setSuccessMsg(data)), response);
    }

    public static void returnErrorMsg(ErrorMsgEnum errorMsgEnum, HttpServletResponse response) {
       ServletUtil.writeString(JSON.toJSONString(ResultMsg.setErrorMsg(errorMsgEnum)), response);
    }

    private static void initResponse(HttpServletResponse res) {
        res.setContentType("application/json;charset=UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Request-Method", "POST");
        res.setHeader("Access-Control-Request-Headers", "token");
    }
}

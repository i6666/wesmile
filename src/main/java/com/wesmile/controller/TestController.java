package com.wesmile.controller;

import com.github.pagehelper.PageHelper;
import com.wesmile.base.BasePage;
import com.wesmile.bean.Content;
import com.wesmile.service.ContentService;
import com.wesmile.util.ServletUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by zma on 2019/05/29
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ContentService contentService;
    @GetMapping("/hello")
    public void hello(HttpServletResponse response, BasePage basePage){

        PageHelper.startPage(basePage.getPageNum(),basePage.getPageSize());
        List<Content> contents = contentService.selectByType(0);
        ServletUtil.returnSuccessMsg(contents,response);
    }


}

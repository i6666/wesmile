package com.wesmile.controller;

import com.github.pagehelper.PageHelper;
import com.wesmile.base.BasePage;
import com.wesmile.bean.Content;
import com.wesmile.bean.File;
import com.wesmile.enums.ErrorMsgEnum;
import com.wesmile.service.ContentService;
import com.wesmile.service.FileService;
import com.wesmile.util.ServletUtil;
import com.wesmile.vo.requestVo.ContentReqVo;
import com.wesmile.vo.responseVo.ContentResVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zma on 2019/06/12
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ContentController {
    @Resource
    private ContentService contentService;

    @Resource
    private FileService fileService;

    @RequestMapping("findContentList")
    public void findContentList(HttpServletResponse response, ContentReqVo contentVo, BasePage basePage) {
        try {
            //需要分页 则开启
            if (basePage.getPageSize() != null && basePage.getPageSize() > 0) {
                PageHelper.startPage(basePage.getPageNum(), basePage.getPageSize());
            }
            List<Content> contents = contentService.selectByType(contentVo.getType());
            List<ContentResVo> contentResVos = getContentResVos(contents);
            ServletUtil.returnSuccessMsg(contentResVos, response);
        } catch (Exception e) {
            log.error("查询内容时发生异常", e);
            ServletUtil.returnErrorMsg(ErrorMsgEnum.SYSTEM_ERROR, response);
        }
    }

    /**
     * 封装返回结果
     *
     * @param contents 元数据
     * @return 所需结果
     */
    private List<ContentResVo> getContentResVos(List<Content> contents) {
        List<ContentResVo> contentResVos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(contents)) {
            for (Content content : contents) {
                ContentResVo contentResVo = new ContentResVo();
                BeanUtils.copyProperties(content, contentResVo);
                Integer fileId = content.getFileId();
                if (!StringUtils.isEmpty(fileId)) {
                    List<File> files = fileService.selectByFileId(fileId);
                    List<String> collect = files.stream().map(File::getPicUrl).collect(Collectors.toList());
                    contentResVo.setFileList(collect);
                }
                contentResVos.add(contentResVo);

            }
        }
        return contentResVos;
    }
}

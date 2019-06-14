package com.wesmile.service.impl;

import com.wesmile.bean.Content;
import com.wesmile.bean.ContentExample;
import com.wesmile.mapper.ContentMapper;
import com.wesmile.service.ContentService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by zma on 2019/05/29
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    private ContentMapper contentMapper;

    private final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);


    public List<Content> selectByType(Integer type){
        ContentExample contentExample = new ContentExample();
        contentExample.createCriteria().andTypeEqualTo(type);
        return contentMapper.selectByExample(contentExample);
    }

    /**
     * 获取段子网数据
     *
     * @param path
     */
    @Transactional(rollbackFor = Exception.class)
    public void getDuanZiWang(String path) {
        try {
            // 根据path获取html文档
            Document document = Jsoup.connect(path).get();
            //根据选择器获取所有list
            Elements postTitleS = document.select(".post");
            //解析list
            for (Element postTitle : postTitleS) {
                Elements title = postTitle.select("div > a:nth-child(4)");
                String tag = title.text();
                String c = "";
                String t = "";
                Elements selectContent = postTitle.select("div> p");
                Elements p2 = postTitle.select(".post-title");
                if (p2.hasText()) {
                    c = p2.text();
                    if (c.length() < 20) {
                        t = p2.text();
                    } else {
                        t = tag;
                    }
                }
                if (selectContent.hasText()) {
                    c = selectContent.text();
                }
                Content content = new Content();
                content.setContent(c);
                content.setFetchTime(new Date());
                content.setCreateTime(new Date());
                content.setUpdateTimes(new Date());
                content.setTitle(t);
                content.setTag(tag);
                content.setSource("dzw");
                content.setType(0);
                contentMapper.insert(content);
                logger.info(t + "------" + c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
        }
    }

    /**
     * 获取
     *
     * @throws Exception
     */

    public void getJingDianDZ(String path) throws IOException {
        path = "http://ishuo.cn/joke/";
        // 根据path获取html文档
        Document document = Jsoup.connect(path).get();
        //根据选择器获取所有list
        Elements listLi = document.select(".list_li");
        for (Element element : listLi) {
            Elements c = element.select(".content");
            Elements t = element.select(".info > a");
            Elements tag = element.select(" span > a:nth-child(3)");
            Content content = new Content();
            content.setContent(c.text());
            content.setFetchTime(new Date());
            content.setCreateTime(new Date());
            content.setUpdateTimes(new Date());
            content.setTitle(t.text());
            content.setTag(tag.text());
            content.setSource("jddz");
            content.setType(0);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tag.text() + "-----" + t.text() + "-----" + c.text());
            contentMapper.insert(content);
        }


    }

}

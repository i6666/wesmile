package com.wesmile;

import com.wesmile.bean.Content;
import com.wesmile.bean.ContentExample;
import com.wesmile.mapper.ContentMapper;
import com.wesmile.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WesmileApplicationTests {

    @Autowired
    private ContentMapper contentMapper;

    @Test
    public void contextLoads() {
        ContentExample contentExample = new ContentExample();
        Page page = new Page();
        page.setPageNum(0);
        page.setPageSize(10);
        contentExample.setPage(page);
        ContentExample.Criteria criteria = contentExample.createCriteria();
        criteria.andSourceEqualTo("dzw");
        List<Content> contents = contentMapper.selectByExample(contentExample);
        System.out.println(contents);
    }

}

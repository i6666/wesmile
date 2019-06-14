package com.wesmile.service;

import com.wesmile.bean.Content;

import java.io.IOException;
import java.util.List;

/**
 * Created by zma on 2019/05/29
 */
public interface ContentService {

    /**
     * 获取段子网数据
     *
     * @param path
     */
    public void getDuanZiWang(String path);

    public void getJingDianDZ(String path) throws IOException;

    public List<Content> selectByType(Integer type);
}

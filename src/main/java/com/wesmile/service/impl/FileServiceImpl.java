package com.wesmile.service.impl;

import com.wesmile.bean.File;
import com.wesmile.bean.FileExample;
import com.wesmile.mapper.FileMapper;
import com.wesmile.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zma on 2019/06/12
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileMapper fileMapper;

    @Override
    public List<File> selectByFileId(Integer fileId) {
        FileExample fileExample = new FileExample();
        fileExample.createCriteria().andIdEqualTo(fileId);
         return  fileMapper.selectByExample(fileExample);
    }
}

package com.wesmile.service;

import com.wesmile.bean.File;

import java.util.List;

/**
 * Created by zma on 2019/06/12
 */
public interface FileService {

    List<File> selectByFileId(Integer fileId);
}

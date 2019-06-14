package com.wesmile.mapper;

import com.wesmile.bean.File;
import com.wesmile.bean.FileExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    /**
     * auto generate
     * @param example
     * @return long
     * @date 2019-06-12 14:35:39
     *
     * @author generator
     */
    long countByExample(FileExample example);

    /**
     * auto generate
     * @param example
     * @return int
     * @date 2019-06-12 14:35:39
     *
     * @author generator
     */
    int deleteByExample(FileExample example);

    /**
     * auto generate
     * @param record
     * @return int
     * @date 2019-06-12 14:35:39
     *
     * @author generator
     */
    int insert(File record);

    /**
     * auto generate
     * @param record
     * @return int
     * @date 2019-06-12 14:35:39
     *
     * @author generator
     */
    int insertSelective(File record);

    /**
     * auto generate
     * @param example
     * @return java.util.List<com.wesmile.bean.File>
     * @date 2019-06-12 14:35:39
     *
     * @author generator
     */
    List<File> selectByExample(FileExample example);

    /**
     * auto generate
     * @param record
     * @param example
     * @return int
     * @date 2019-06-12 14:35:39
     *
     * @author generator
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     * auto generate
     * @param record
     * @param example
     * @return int
     * @date 2019-06-12 14:35:39
     *
     * @author generator
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int insertBatchSelective(List<File> records);

    int insertBatch(List<File> records);
}
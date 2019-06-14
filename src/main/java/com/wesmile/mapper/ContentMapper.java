package com.wesmile.mapper;

import com.wesmile.bean.Content;
import com.wesmile.bean.ContentExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
public interface ContentMapper {
    /**
     * auto generate
     * @param example
     * @return long
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    long countByExample(ContentExample example);

    /**
     * auto generate
     * @param example
     * @return int
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    int deleteByExample(ContentExample example);

    /**
     * auto generate
     * @param record
     * @return int
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    int insert(Content record);

    /**
     * auto generate
     * @param record
     * @return int
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    int insertSelective(Content record);

    /**
     * auto generate
     * @param example
     * @return java.util.List<com.wesmile.bean.Content>
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    List<Content> selectByExampleWithBLOBs(ContentExample example);

    /**
     * auto generate
     * @param example
     * @return java.util.List<com.wesmile.bean.Content>
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    List<Content> selectByExample(ContentExample example);

    /**
     * auto generate
     * @param record
     * @param example
     * @return int
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    /**
     * auto generate
     * @param record
     * @param example
     * @return int
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);

    /**
     * auto generate
     * @param record
     * @param example
     * @return int
     * @date 2019-06-12 14:35:09
     *
     * @author generator
     */
    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int insertBatchSelective(List<Content> records);

    int insertBatch(List<Content> records);
}
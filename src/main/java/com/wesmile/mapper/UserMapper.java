package com.wesmile.mapper;

import com.wesmile.bean.User;
import com.wesmile.bean.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * auto generate
     * @param example
     * @return long
     * @date 2019-06-12 14:35:22
     *
     * @author generator
     */
    long countByExample(UserExample example);

    /**
     * auto generate
     * @param example
     * @return int
     * @date 2019-06-12 14:35:22
     *
     * @author generator
     */
    int deleteByExample(UserExample example);

    /**
     * auto generate
     * @param record
     * @return int
     * @date 2019-06-12 14:35:22
     *
     * @author generator
     */
    int insert(User record);

    /**
     * auto generate
     * @param record
     * @return int
     * @date 2019-06-12 14:35:22
     *
     * @author generator
     */
    int insertSelective(User record);

    /**
     * auto generate
     * @param example
     * @return java.util.List<com.wesmile.bean.User>
     * @date 2019-06-12 14:35:22
     *
     * @author generator
     */
    List<User> selectByExample(UserExample example);

    /**
     * auto generate
     * @param record
     * @param example
     * @return int
     * @date 2019-06-12 14:35:22
     *
     * @author generator
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * auto generate
     * @param record
     * @param example
     * @return int
     * @date 2019-06-12 14:35:22
     *
     * @author generator
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int insertBatchSelective(List<User> records);

    int insertBatch(List<User> records);
}
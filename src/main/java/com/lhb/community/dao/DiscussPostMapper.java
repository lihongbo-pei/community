package com.lhb.community.dao;

import com.lhb.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author littlelee
 * @date 2020/12/4 23:57
 */
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    // @Param注释用于给参数取别名，
    // 如果只有一个参数，并且在<if>里使用，则必须加
    int selectDiscussPostRows(@Param("userId") int userId);

}
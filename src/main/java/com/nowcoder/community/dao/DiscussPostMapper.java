package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper        // 定义增删改查的方法
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode);

    // @Param 注解用于给参数取别名
<<<<<<< HEAD
    // 如果只有一个参数，并且在<if>里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);  // 动态SQL

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);   // 查询帖子
=======
    // 如果只有一个参数，并且在动态SQL语句<if>里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);
>>>>>>> 3431474cdd97cde07b1aa08fe766e0124199e2e0

    int updateCommentCount(int id, int commentCount);

    int updateType(int id, int type);

    int updateStatus(int id, int status);

    int updateScore(int id, double score);

}

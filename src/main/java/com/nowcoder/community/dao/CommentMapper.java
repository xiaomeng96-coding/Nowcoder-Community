package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);  // 查询评论

    int selectCountByEntity(int entityType, int entityId);   // 查询评论总数

    int insertComment(Comment comment);

    Comment selectCommentById(int id);

}

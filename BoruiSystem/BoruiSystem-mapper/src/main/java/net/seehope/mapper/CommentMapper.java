package net.seehope.mapper;

import net.seehope.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Repository
public interface CommentMapper extends tk.mybatis.mapper.common.Mapper<Comment> {

    // 查询所有的评论
    List getAllComment(String postID);

}





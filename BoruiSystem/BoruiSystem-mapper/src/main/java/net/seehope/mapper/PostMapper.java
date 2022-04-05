package net.seehope.mapper;

import net.seehope.pojo.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
@Repository
public interface PostMapper extends tk.mybatis.mapper.common.Mapper<Post> {


    // 查询所有的发帖
    List getAllPost();

}





package net.seehope.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`post`")
public class Post implements Serializable {
    @Column(name = "`user_id`")
    private String userId;

    @Column(name = "`title`")
    private String title;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`post_id`")
    private String postId;

    private static final long serialVersionUID = 1L;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return post_id
     */
    public String getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }
}
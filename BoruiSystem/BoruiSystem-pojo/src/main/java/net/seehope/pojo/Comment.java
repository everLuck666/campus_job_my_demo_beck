package net.seehope.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`comment`")
public class Comment implements Serializable {
    @Column(name = "`post_id`")
    private String postId;

    @Column(name = "`title`")
    private String title;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`user_id`")
    private String userId;

    @Column(name = "`user_src`")
    private String userSrc;

    @Column(name = "`comment_id`")
    private String commentId;

    private static final long serialVersionUID = 1L;

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
     * @return user_src
     */
    public String getUserSrc() {
        return userSrc;
    }

    /**
     * @param userSrc
     */
    public void setUserSrc(String userSrc) {
        this.userSrc = userSrc;
    }

    /**
     * @return comment_id
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
package net.seehope.pojo;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private String from;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    public String getFromUserProfile() {
        return fromUserProfile;
    }

    public void setFromUserProfile(String fromUserProfile) {
        this.fromUserProfile = fromUserProfile;
    }

    public Integer getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Integer messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    private String content;
    private Date createTime;
    private String fromNickname;
    private String fromUserProfile;
    private Integer messageTypeId;



}

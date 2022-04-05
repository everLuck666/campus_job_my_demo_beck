package net.seehope.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`online`")
public class Online implements Serializable {
    @Id
    @Column(name = "`user_id`")
    private String userId;

    @Column(name = "`online`")
    private String online;

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
     * @return online
     */
    public String getOnline() {
        return online;
    }

    /**
     * @param online
     */
    public void setOnline(String online) {
        this.online = online;
    }
}
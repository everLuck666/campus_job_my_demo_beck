package net.seehope.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`intention`")
public class Intention implements Serializable {
    @Column(name = "`enterpirse_id`")
    private String enterpirseId;

    @Column(name = "`user_id`")
    private String userId;

    @Column(name = "`status`")
    private String status;

    private static final long serialVersionUID = 1L;

    /**
     * @return enterpirse_id
     */
    public String getEnterpirseId() {
        return enterpirseId;
    }

    /**
     * @param enterpirseId
     */
    public void setEnterpirseId(String enterpirseId) {
        this.enterpirseId = enterpirseId;
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
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
package net.seehope.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`enterprise_relation`")
public class EnterpriseRelation implements Serializable {
    @Id
    @Column(name = "`user_id`")
    private String userId;

    @Column(name = "`enterprise_id`")
    private String enterpriseId;

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
     * @return enterprise_id
     */
    public String getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     */
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
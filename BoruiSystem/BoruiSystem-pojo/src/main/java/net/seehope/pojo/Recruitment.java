package net.seehope.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`recruitment`")
public class Recruitment implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 岗位id
     */
    @Column(name = "`station_id`")
    private String stationId;

    /**
     * 学生id
     */
    @Column(name = "`user_id`")
    private String userId;

    /**
     * 0未删，1删除
     */
    @Column(name = "`delete_flag`")
    private Short deleteFlag;

    /**
     * 招聘证明
     */
    @Column(name = "`employment_file`")
    private String employmentFile;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取岗位id
     *
     * @return station_id - 岗位id
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置岗位id
     *
     * @param stationId 岗位id
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * 获取学生id
     *
     * @return user_id - 学生id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置学生id
     *
     * @param userId 学生id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取0未删，1删除
     *
     * @return delete_flag - 0未删，1删除
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置0未删，1删除
     *
     * @param deleteFlag 0未删，1删除
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取招聘证明
     *
     * @return employment_file - 招聘证明
     */
    public String getEmploymentFile() {
        return employmentFile;
    }

    /**
     * 设置招聘证明
     *
     * @param employmentFile 招聘证明
     */
    public void setEmploymentFile(String employmentFile) {
        this.employmentFile = employmentFile;
    }
}